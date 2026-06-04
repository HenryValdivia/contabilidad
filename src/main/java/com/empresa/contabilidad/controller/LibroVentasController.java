package com.empresa.contabilidad.controller;

import com.empresa.contabilidad.entity.LibroVentas;
import com.empresa.contabilidad.service.LibroVentasService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libro-ventas")
public class LibroVentasController {

    private final LibroVentasService service;

    public LibroVentasController(LibroVentasService service) { this.service = service; }

    @GetMapping
    public List<LibroVentas> all() { return service.findAll(); }

    @GetMapping("/{id}")
    public LibroVentas one(@PathVariable Integer id) { return service.findById(id); }

    @PostMapping
    public ResponseEntity<LibroVentas> create(@Valid @RequestBody LibroVentas dto) { return ResponseEntity.ok(service.create(dto)); }

    @PutMapping("/{id}")
    public LibroVentas update(@PathVariable Integer id, @Valid @RequestBody LibroVentas dto) { return service.update(id, dto); }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) { service.delete(id); return ResponseEntity.noContent().build(); }
}
