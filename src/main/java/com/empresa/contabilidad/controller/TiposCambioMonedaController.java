package com.empresa.contabilidad.controller;

import com.empresa.contabilidad.entity.TiposCambioMoneda;
import com.empresa.contabilidad.entity.TiposCambioMonedaId;
import com.empresa.contabilidad.service.TiposCambioMonedaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/tipos-cambio")
public class TiposCambioMonedaController {

    private final TiposCambioMonedaService service;

    public TiposCambioMonedaController(TiposCambioMonedaService service) { this.service = service; }

    @GetMapping
    public List<TiposCambioMoneda> all() { return service.findAll(); }

    @GetMapping("/{fecha}/{codMoneda}")
    public TiposCambioMoneda one(@PathVariable String fecha, @PathVariable Integer codMoneda) {
        LocalDateTime dt = LocalDateTime.parse(fecha);
        return service.findById(new TiposCambioMonedaId(dt, codMoneda));
    }

    @PostMapping
    public ResponseEntity<TiposCambioMoneda> create(@Valid @RequestBody TiposCambioMoneda dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{fecha}/{codMoneda}")
    public TiposCambioMoneda update(@PathVariable String fecha, @PathVariable Integer codMoneda, @Valid @RequestBody TiposCambioMoneda dto) {
        LocalDateTime dt = LocalDateTime.parse(fecha);
        return service.update(new TiposCambioMonedaId(dt, codMoneda), dto);
    }

    @DeleteMapping("/{fecha}/{codMoneda}")
    public ResponseEntity<?> delete(@PathVariable String fecha, @PathVariable Integer codMoneda) {
        LocalDateTime dt = LocalDateTime.parse(fecha);
        service.delete(new TiposCambioMonedaId(dt, codMoneda));
        return ResponseEntity.noContent().build();
    }
}
