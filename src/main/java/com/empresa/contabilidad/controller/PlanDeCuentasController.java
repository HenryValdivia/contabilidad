package com.empresa.contabilidad.controller;

import com.empresa.contabilidad.entity.PlanDeCuentas;
import com.empresa.contabilidad.entity.PlanDeCuentasId;
import com.empresa.contabilidad.service.PlanDeCuentasService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plan-de-cuentas")
public class PlanDeCuentasController {

    private final PlanDeCuentasService service;

    public PlanDeCuentasController(PlanDeCuentasService service) { this.service = service; }

    @GetMapping
    public List<PlanDeCuentas> all() { return service.findAll(); }

    @GetMapping("/{codPlanCuenta}/{codGestion}")
    public PlanDeCuentas one(@PathVariable Integer codPlanCuenta, @PathVariable Integer codGestion) {
        return service.findById(new PlanDeCuentasId(codPlanCuenta, codGestion));
    }

    @PostMapping
    public ResponseEntity<PlanDeCuentas> create(@Valid @RequestBody PlanDeCuentas dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{codPlanCuenta}/{codGestion}")
    public PlanDeCuentas update(@PathVariable Integer codPlanCuenta, @PathVariable Integer codGestion, @Valid @RequestBody PlanDeCuentas dto) {
        return service.update(new PlanDeCuentasId(codPlanCuenta, codGestion), dto);
    }

    @DeleteMapping("/{codPlanCuenta}/{codGestion}")
    public ResponseEntity<?> delete(@PathVariable Integer codPlanCuenta, @PathVariable Integer codGestion) {
        service.delete(new PlanDeCuentasId(codPlanCuenta, codGestion));
        return ResponseEntity.noContent().build();
    }
}
