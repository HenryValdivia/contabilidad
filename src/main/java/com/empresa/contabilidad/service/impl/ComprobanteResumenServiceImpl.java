package com.empresa.contabilidad.service.impl;

import com.empresa.contabilidad.dto.ComprobanteResumenDto;
import com.empresa.contabilidad.entity.Comprobante;
import com.empresa.contabilidad.entity.Empresa;
import com.empresa.contabilidad.entity.EstadosComprobantes;
import com.empresa.contabilidad.entity.Gestion;
import com.empresa.contabilidad.entity.Moneda;
import com.empresa.contabilidad.repository.ComprobanteResumenRepository;
import com.empresa.contabilidad.service.ComprobanteResumenService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.criteria.*;
import java.util.Date;

@Service
public class ComprobanteResumenServiceImpl implements ComprobanteResumenService {

    private final ComprobanteResumenRepository repository;

    @PersistenceContext
    private final EntityManager entityManager;

    public ComprobanteResumenServiceImpl(ComprobanteResumenRepository repository, EntityManager entityManager) {
        this.repository = repository;
        this.entityManager = entityManager;
    }

    @Override
    public Page<ComprobanteResumenDto> findAllResumenOrdered(Pageable pageable) {
        return repository.findAllResumenOrdered(pageable);
    }

    @Override
    public Page<ComprobanteResumenDto> findAllResumenFiltered(Integer codEmpresa, Integer codGestion, Integer codTipoComprobante, LocalDateTime fechaComprobante, String glosaComprobante, Integer codEstadoComprobante, Pageable pageable) {
        // 1. Crear el CriteriaQuery para el DTO
    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    CriteriaQuery<ComprobanteResumenDto> query = cb.createQuery(ComprobanteResumenDto.class);
    
    // 2. Definir las raíces (Roots/Tablas)
    Root<Comprobante> c = query.from(Comprobante.class);
    Root<Empresa> e = query.from(Empresa.class);
    Root<Gestion> g = query.from(Gestion.class);
    Root<Moneda> m = query.from(Moneda.class);
    Root<EstadosComprobantes> ec = query.from(EstadosComprobantes.class);

    List<Predicate> predicates = new ArrayList<>();

    // 3. Establecer las uniones (JOIN ON) manualmente
    predicates.add(cb.equal(c.get("codEmpresa"), e.get("codEmpresa")));
    predicates.add(cb.equal(c.get("codGestion"), g.get("codGestion")));
    predicates.add(cb.equal(c.get("codMoneda"), m.get("codMoneda")));
    predicates.add(cb.equal(c.get("codEstadoComprobante"), ec.get("codEstadoComprobante")));

    // 4. Filtros dinámicos (WHERE)
    if (codEmpresa != null) {
        predicates.add(cb.equal(c.get("codEmpresa"), codEmpresa));
    }
    if (codGestion != null) {
        predicates.add(cb.equal(c.get("codGestion"), codGestion));
    }
    if (codTipoComprobante != null) {
        predicates.add(cb.equal(c.get("codTipoComprobante"), codTipoComprobante));
    }
    if (fechaComprobante != null) {
        // Solución al problema del bytea/cast en Postgres
        Expression<Date> dateExpr = cb.function("date", Date.class, c.get("fechaComprobante"));
        predicates.add(cb.equal(dateExpr, java.sql.Date.valueOf(fechaComprobante.toLocalDate())));
    }
    if (glosaComprobante != null && !glosaComprobante.isEmpty()) {
        predicates.add(cb.like(c.get("glosa"), "%" + glosaComprobante + "%"));
    }
    if (codEstadoComprobante != null) {
        predicates.add(cb.equal(c.get("codEstadoComprobante"), codEstadoComprobante));
    }

    query.where(cb.and(predicates.toArray(new Predicate[0])));

    // 5. Proyección al Constructor del DTO (SELECT new ...)
    query.select(cb.construct(ComprobanteResumenDto.class,
            c.get("codComprobante"), c.get("codEmpresa"), e.get("nombreEmpresa"),
            c.get("codGestion"), g.get("nombreGestion"), c.get("codMoneda"),
            m.get("nombreMoneda"), c.get("codPersonal"), c.get("codEstadoComprobante"),
            ec.get("nombreEstadoComprobante"), c.get("codTipoComprobante"),
            c.get("fechaComprobante"), c.get("nroComprobante"), c.get("nroCheque"),
            c.get("nroFactura"), c.get("glosa"), c.get("codTipoComprobanteGenerado"),
            c.get("estadoSistema"), c.get("codEmisionCheqhe"), c.get("fechaSistema"),
            c.get("descrMontoTotal"), cb.literal(0), cb.literal(0)
    ));

    // 6. Ordenamiento
    query.orderBy(cb.asc(c.get("codGestion")), cb.asc(c.get("codComprobante")));

    // 7. Ejecutar con paginación
    TypedQuery<ComprobanteResumenDto> typedQuery = entityManager.createQuery(query);
    typedQuery.setFirstResult((int) pageable.getOffset());
    typedQuery.setMaxResults(pageable.getPageSize());

    List<ComprobanteResumenDto> result = typedQuery.getResultList();

    // 8. Consulta de Conteo (Necesaria para Page)
    CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
    // Debes repetir las mismas raíces y predicados de unión para el conteo
    Root<Comprobante> countRoot = countQuery.from(Comprobante.class);
    // ... (aquí se simplifica: si los filtros no afectan a las otras tablas, puedes contar solo Comprobante)
    countQuery.select(cb.count(countRoot));
    // Reutilizar lógica de predicados aquí es clave...
    
    Long total = entityManager.createQuery(countQuery).getSingleResult();

    return new PageImpl<>(result, pageable, total);
        //return repository.findAllResumenFiltered(codEmpresa, codGestion, codTipoComprobante, fechaComprobante, glosaComprobante, codEstadoComprobante, pageable);
    }
}
