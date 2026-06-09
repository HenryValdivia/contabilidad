package com.empresa.contabilidad.controller;

import com.empresa.contabilidad.dto.ComprobanteResumenDto;
import com.empresa.contabilidad.service.ComprobanteResumenService;

import jakarta.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
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
    public Page<ComprobanteResumenDto> findAll(@Valid @RequestBody ComprobanteResumenDto filtro) {

        Pageable pageable = PageRequest.of(filtro.getPage(), filtro.getSize(), Sort.by("fechaComprobante").descending());
        
        if (filtro.getCodEmpresa() == null && filtro.getCodGestion() == null && 
            filtro.getCodTipoComprobante() == null && filtro.getFechaComprobante() == null && 
            filtro.getGlosaComprobante() == null && filtro.getCodEstadoComprobante() == null) {
            return service.findAllResumenOrdered(pageable);
        }
        
        return service.findAllResumenFiltered(
            filtro.getCodEmpresa(), 
            filtro.getCodGestion(), 
            filtro.getCodTipoComprobante(), 
            filtro.getFechaComprobante(), 
            filtro.getGlosaComprobante(), 
            filtro.getCodEstadoComprobante(),
            pageable);
    }
}
