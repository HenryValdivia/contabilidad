package com.empresa.contabilidad.controller;

import com.empresa.contabilidad.dto.ComprobanteDto;
import com.empresa.contabilidad.entity.Comprobante;
import com.empresa.contabilidad.entity.ComprobanteDetalle;
import com.empresa.contabilidad.entity.ComprobanteId;
import com.empresa.contabilidad.service.ComprobanteDetalleService;
import com.empresa.contabilidad.service.ComprobanteService;
import com.google.gson.Gson;

import jakarta.validation.Valid;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comprobantes")
public class ComprobanteController {

    private final ComprobanteService service;
    private final ComprobanteDetalleService detalleService;

    public ComprobanteController(ComprobanteService service, ComprobanteDetalleService detalleService) {
        this.service = service;
        this.detalleService = detalleService;
    }

    @GetMapping
    public List<Comprobante> all() { return service.findAll(); }

    @GetMapping("/{codComprobante}/{codGestion}")
    public Comprobante one(@PathVariable Integer codComprobante, @PathVariable Integer codGestion) {
        return service.findById(new ComprobanteId(codComprobante, codGestion));
    }

    @PostMapping
    public ResponseEntity<Comprobante> create(@Valid @RequestBody Comprobante dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PostMapping("/guardarComprobante")
    @Transactional
    public ResponseEntity<Comprobante> guardarComprobante(@Valid @RequestBody ComprobanteDto comprobanteDto) throws Exception {
        Comprobante comprobante = comprobanteDto.getComprobante();
        if (comprobante == null) {
            return ResponseEntity.badRequest().build();
        }

        System.out.println("Datos recibidos: " + comprobante.getFechaComprobante());

        Comprobante savedComprobante = service.create(comprobante);

        if (comprobanteDto.getComprobanteDetalleList() != null) {
            for (ComprobanteDetalle detalle : comprobanteDto.getComprobanteDetalleList()) {
                detalle.setCodComprobante(savedComprobante.getCodComprobante());
                detalle.setCodGestion(savedComprobante.getCodGestion());
                detalleService.create(detalle);
            }
        }

        return ResponseEntity.ok(savedComprobante);
    }

    @PutMapping("/{codComprobante}/{codGestion}")
    public Comprobante update(@PathVariable Integer codComprobante, @PathVariable Integer codGestion, @Valid @RequestBody Comprobante dto) {
        return service.update(new ComprobanteId(codComprobante, codGestion), dto);
    }

    @DeleteMapping("/{codComprobante}/{codGestion}")
    public ResponseEntity<?> delete(@PathVariable Integer codComprobante, @PathVariable Integer codGestion){
        service.delete(new ComprobanteId(codComprobante, codGestion));
        return ResponseEntity.noContent().build();
    }
}
