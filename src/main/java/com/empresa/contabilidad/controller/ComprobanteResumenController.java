package com.empresa.contabilidad.controller;

import com.empresa.contabilidad.dto.ComprobanteResumenDto;
import com.empresa.contabilidad.service.ComprobanteResumenService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comprobantes/resumen")
public class ComprobanteResumenController {

    private final ComprobanteResumenService service;

    public ComprobanteResumenController(ComprobanteResumenService service) {
        this.service = service;
    }

    @PostMapping
    public List<ComprobanteResumenDto> findAll(@Valid @RequestBody ComprobanteResumenDto filtro) {
        
        if (filtro.getCodEmpresa() == null && filtro.getCodGestion() == null && 
            filtro.getCodTipoComprobante() == null && filtro.getFechaComprobante() == null && 
            filtro.getGlosaComprobante() == null && filtro.getCodEstadoComprobante() == null) {
            return service.findAllResumenOrdered();
        }
        
        return service.findAllResumenFiltered(
            filtro.getCodEmpresa(), 
            filtro.getCodGestion(), 
            filtro.getCodTipoComprobante(), 
            filtro.getFechaComprobante(), 
            filtro.getGlosaComprobante(), 
            filtro.getCodEstadoComprobante());
    }
}
