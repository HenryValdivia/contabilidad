package com.empresa.contabilidad.controller;

import com.empresa.contabilidad.entity.Moneda;
import com.empresa.contabilidad.service.MonedaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/moneda")
public class MonedaController {

    private final MonedaService service;

    public MonedaController(MonedaService service) { this.service = service; }

    @GetMapping
    public List<Moneda> all() { return service.findAll(); }

    @GetMapping("/{id}")
    public Moneda one(@PathVariable Integer id) { return service.findById(id); }

    @PostMapping
    public ResponseEntity<Moneda> create(@Valid @RequestBody Moneda dto) { return ResponseEntity.ok(service.create(dto)); }

    @PutMapping("/{id}")
    public Moneda update(@PathVariable Integer id, @Valid @RequestBody Moneda dto) { return service.update(id, dto); }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) { service.delete(id); return ResponseEntity.noContent().build(); }
}
