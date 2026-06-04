package com.empresa.contabilidad.controller;

import com.empresa.contabilidad.dto.ComprobanteResumenDto;
import com.empresa.contabilidad.service.ComprobanteResumenService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/comprobantes/resumen")
public class ComprobanteResumenController {

    private final ComprobanteResumenService service;

    public ComprobanteResumenController(ComprobanteResumenService service) {
        this.service = service;
    }

    @GetMapping
    public List<ComprobanteResumenDto> findAll() {
        return service.findAllResumenOrdered();
    }
}
