package com.empresa.contabilidad.controller;

import com.empresa.contabilidad.entity.TiposComprobante;
import com.empresa.contabilidad.service.TiposComprobanteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipos-comprobante")
public class TiposComprobanteController {

    private final TiposComprobanteService service;

    public TiposComprobanteController(TiposComprobanteService service) { this.service = service; }

    @GetMapping
    public List<TiposComprobante> all() { return service.findAll(); }

    @GetMapping("/{id}")
    public TiposComprobante one(@PathVariable Integer id) { return service.findById(id); }

    @PostMapping
    public ResponseEntity<TiposComprobante> create(@Valid @RequestBody TiposComprobante dto) { return ResponseEntity.ok(service.create(dto)); }

    @PutMapping("/{id}")
    public TiposComprobante update(@PathVariable Integer id, @Valid @RequestBody TiposComprobante dto) { return service.update(id, dto); }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) { service.delete(id); return ResponseEntity.noContent().build(); }
}
