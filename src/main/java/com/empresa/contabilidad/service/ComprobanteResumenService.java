package com.empresa.contabilidad.service;

import com.empresa.contabilidad.dto.ComprobanteResumenDto;

import java.time.LocalDateTime;
import java.util.List;

public interface ComprobanteResumenService {
    List<ComprobanteResumenDto> findAllResumenOrdered();
    List<ComprobanteResumenDto> findAllResumenFiltered(Integer codEmpresa, Integer codGestion, Integer codTipoComprobante, LocalDateTime fechaComprobante, String glosaComprobante, Integer codEstadoComprobante);
}
