package com.empresa.contabilidad.service;

import com.empresa.contabilidad.dto.ComprobanteResumenDto;

import java.util.List;

public interface ComprobanteResumenService {
    List<ComprobanteResumenDto> findAllResumenOrdered();
}
