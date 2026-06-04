package com.empresa.contabilidad.controller;

import com.empresa.contabilidad.entity.CentroDeCostos;
import com.empresa.contabilidad.service.CentroDeCostosService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/centro-de-costos")
public class CentroDeCostosController {

    private final CentroDeCostosService service;

    public CentroDeCostosController(CentroDeCostosService service) { this.service = service; }

    @GetMapping
    public List<CentroDeCostos> all() { return service.findAll(); }

    @GetMapping("/{id}")
    public CentroDeCostos one(@PathVariable Integer id) { return service.findById(id); }

    @PostMapping
    public ResponseEntity<CentroDeCostos> create(@Valid @RequestBody CentroDeCostos dto) {
        CentroDeCostos created = service.create(dto);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public CentroDeCostos update(@PathVariable Integer id, @Valid @RequestBody CentroDeCostos dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
