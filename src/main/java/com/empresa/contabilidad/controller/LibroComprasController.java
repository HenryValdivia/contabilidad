package com.empresa.contabilidad.controller;

import com.empresa.contabilidad.entity.LibroCompras;
import com.empresa.contabilidad.service.LibroComprasService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libro-compras")
public class LibroComprasController {

    private final LibroComprasService service;

    public LibroComprasController(LibroComprasService service) { this.service = service; }

    @GetMapping
    public List<LibroCompras> all() { return service.findAll(); }

    @GetMapping("/{id}")
    public LibroCompras one(@PathVariable Integer id) { return service.findById(id); }

    @PostMapping
    public ResponseEntity<LibroCompras> create(@Valid @RequestBody LibroCompras dto) { return ResponseEntity.ok(service.create(dto)); }

    @PutMapping("/{id}")
    public LibroCompras update(@PathVariable Integer id, @Valid @RequestBody LibroCompras dto) { return service.update(id, dto); }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) { service.delete(id); return ResponseEntity.noContent().build(); }
}
