package com.empresa.contabilidad.service;

import com.empresa.contabilidad.dto.ComprobanteResumenDto;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ComprobanteResumenService {
    Page<ComprobanteResumenDto> findAllResumenOrdered(Pageable pageable);//se agregó pageable para mantener la consistencia con el método filtrado, aunque no se use en la consulta
    Page<ComprobanteResumenDto> findAllResumenFiltered(Integer codEmpresa, Integer codGestion, Integer codTipoComprobante, LocalDateTime fechaComprobante, String glosaComprobante, Integer codEstadoComprobante, Pageable pageable);
}
