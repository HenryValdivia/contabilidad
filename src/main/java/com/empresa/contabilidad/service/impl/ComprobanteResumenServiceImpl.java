package com.empresa.contabilidad.service.impl;

import com.empresa.contabilidad.dto.ComprobanteResumenDto;
import com.empresa.contabilidad.repository.ComprobanteResumenRepository;
import com.empresa.contabilidad.service.ComprobanteResumenService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ComprobanteResumenServiceImpl implements ComprobanteResumenService {

    private final ComprobanteResumenRepository repository;

    public ComprobanteResumenServiceImpl(ComprobanteResumenRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ComprobanteResumenDto> findAllResumenOrdered() {
        return repository.findAllResumenOrdered();
    }

    @Override
    public List<ComprobanteResumenDto> findAllResumenFiltered(Integer codEmpresa, Integer codGestion, Integer codTipoComprobante, LocalDateTime fechaComprobante, String glosaComprobante, Integer codEstadoComprobante) {
        return repository.findAllResumenFiltered(codEmpresa, codGestion, codTipoComprobante, fechaComprobante, glosaComprobante, codEstadoComprobante);
    }
}
