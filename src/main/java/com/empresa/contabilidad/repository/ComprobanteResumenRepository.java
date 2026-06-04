package com.empresa.contabilidad.repository;

import com.empresa.contabilidad.dto.ComprobanteResumenDto;
import com.empresa.contabilidad.entity.Comprobante;
import com.empresa.contabilidad.entity.ComprobanteId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ComprobanteResumenRepository extends JpaRepository<Comprobante, ComprobanteId> {

    @Query("SELECT new com.empresa.contabilidad.dto.ComprobanteResumenDto(" +
            "c.codComprobante, c.codEmpresa, e.nombreEmpresa, c.codGestion, g.nombreGestion, " +
            "c.codMoneda, m.nombreMoneda, c.codPersonal, c.codEstadoComprobante, ec.nombreEstadoComprobante, " +
            "c.codTipoComprobante, c.fechaComprobante, c.nroComprobante, c.nroCheque, c.nroFactura, " +
            "c.glosa, c.codTipoComprobanteGenerado, c.estadoSistema, c.codEmisionCheqhe, c.fechaSistema, c.descrMontoTotal) " +
            "FROM Comprobante c " +
            "JOIN Empresa e ON e.codEmpresa = c.codEmpresa " +
            "JOIN Gestion g ON g.codGestion = c.codGestion " +
            "JOIN Moneda m ON m.codMoneda = c.codMoneda " +
            "JOIN EstadosComprobantes ec ON ec.codEstadoComprobante = c.codEstadoComprobante " +
            "ORDER BY c.codGestion, c.codComprobante")
    List<ComprobanteResumenDto> findAllResumenOrdered();

    @Query("SELECT new com.empresa.contabilidad.dto.ComprobanteResumenDto(" +
            "c.codComprobante, c.codEmpresa, e.nombreEmpresa, c.codGestion, g.nombreGestion, " +
            "c.codMoneda, m.nombreMoneda, c.codPersonal, c.codEstadoComprobante, ec.nombreEstadoComprobante, " +
            "c.codTipoComprobante, c.fechaComprobante, c.nroComprobante, c.nroCheque, c.nroFactura, " +
            "c.glosa, c.codTipoComprobanteGenerado, c.estadoSistema, c.codEmisionCheqhe, c.fechaSistema, c.descrMontoTotal) " +
            "FROM Comprobante c " +
            "JOIN Empresa e ON e.codEmpresa = c.codEmpresa " +
            "JOIN Gestion g ON g.codGestion = c.codGestion " +
            "JOIN Moneda m ON m.codMoneda = c.codMoneda " +
            "JOIN EstadosComprobantes ec ON ec.codEstadoComprobante = c.codEstadoComprobante " +
            "WHERE (CAST(:codEmpresa AS integer) IS NULL OR c.codEmpresa = :codEmpresa) " +
            "AND (CAST(:codGestion AS integer) IS NULL OR c.codGestion = :codGestion) " +
            "AND (CAST(:codTipoComprobante AS integer) IS NULL OR c.codTipoComprobante = :codTipoComprobante) " +
            "AND (CAST(:fechaComprobante AS date) IS NULL OR CAST(c.fechaComprobante AS date) = CAST(:fechaComprobante AS date)) " +
            "AND (CAST(:glosaComprobante AS string) IS NULL OR c.glosa LIKE CONCAT('%', :glosaComprobante, '%')) " +
            "AND (CAST(:codEstadoComprobante AS integer) IS NULL OR c.codEstadoComprobante = :codEstadoComprobante) " +
            "ORDER BY c.codGestion, c.codComprobante")
    List<ComprobanteResumenDto> findAllResumenFiltered(
            @Param("codEmpresa") Integer codEmpresa,
            @Param("codGestion") Integer codGestion,
            @Param("codTipoComprobante") Integer codTipoComprobante,
            @Param("fechaComprobante") LocalDateTime fechaComprobante,
            @Param("glosaComprobante") String glosaComprobante,
            @Param("codEstadoComprobante") Integer codEstadoComprobante
    );
}
