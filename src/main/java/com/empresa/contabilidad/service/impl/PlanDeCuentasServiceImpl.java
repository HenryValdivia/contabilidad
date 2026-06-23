package com.empresa.contabilidad.service.impl;

import com.empresa.contabilidad.entity.PlanDeCuentas;
import com.empresa.contabilidad.entity.PlanDeCuentasId;
import com.empresa.contabilidad.exception.ResourceNotFoundException;
import com.empresa.contabilidad.repository.PlanDeCuentasRepository;
import com.empresa.contabilidad.service.PlanDeCuentasService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PlanDeCuentasServiceImpl implements PlanDeCuentasService {

    private final PlanDeCuentasRepository repo;

    public PlanDeCuentasServiceImpl(PlanDeCuentasRepository repo) { this.repo = repo; }

    @Override
    public List<PlanDeCuentas> findAll() { return repo.findAll(); }

    @Override
    public PlanDeCuentas findById(PlanDeCuentasId id) {
        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("PlanDeCuentas not found"));
    }

    @Override
    public PlanDeCuentas create(PlanDeCuentas dto) { return repo.save(dto); }

    @Override
    public PlanDeCuentas update(PlanDeCuentasId id, PlanDeCuentas dto) {
        PlanDeCuentas existing = findById(id);
        dto.setCodPlanCuenta(existing.getCodPlanCuenta());
        dto.setCodGestion(existing.getCodGestion());
        return repo.save(dto);
    }

    @Override
    public void delete(PlanDeCuentasId id) {
        PlanDeCuentas existing = findById(id);
        repo.delete(existing);
    }

    @Transactional(readOnly = true)
    @Override
    public List<PlanDeCuentas> buscarPlanDeCuentas(PlanDeCuentas p) {
        // Enviar cadenas vacías asegura que el Query Method con Containing busque todos los registros
        // si el usuario no proporciona un filtro específico.
        String filtroCod = p.getCodCuenta() != null ? p.getCodCuenta() : "";
        String filtroNombre = p.getNombreCuenta() != null ? p.getNombreCuenta() : "";

        return repo.findByCodCuentaStartingWithIgnoreCaseAndNombreCuentaStartingWithIgnoreCase(
                filtroCod, 
                filtroNombre
        );
    }
}
