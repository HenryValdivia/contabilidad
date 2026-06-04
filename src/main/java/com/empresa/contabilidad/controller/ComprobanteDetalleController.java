package com.empresa.contabilidad.controller;

import com.empresa.contabilidad.entity.ComprobanteDetalle;
import com.empresa.contabilidad.service.ComprobanteDetalleService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comprobante-detalle")
public class ComprobanteDetalleController {

    private final ComprobanteDetalleService service;

    public ComprobanteDetalleController(ComprobanteDetalleService service) { this.service = service; }

    @GetMapping
    public List<ComprobanteDetalle> all() { return service.findAll(); }

    @GetMapping("/{id}")
    public ComprobanteDetalle one(@PathVariable Integer id) { return service.findById(id); }

    @PostMapping
    public ResponseEntity<ComprobanteDetalle> create(@Valid @RequestBody ComprobanteDetalle dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ComprobanteDetalle update(@PathVariable Integer id, @Valid @RequestBody ComprobanteDetalle dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
