package com.empresa.contabilidad.service;

import com.empresa.contabilidad.entity.PlanDeCuentas;
import com.empresa.contabilidad.entity.PlanDeCuentasId;

import java.util.List;

public interface PlanDeCuentasService {
    List<PlanDeCuentas> findAll();
    PlanDeCuentas findById(PlanDeCuentasId id);
    PlanDeCuentas create(PlanDeCuentas dto);
    PlanDeCuentas update(PlanDeCuentasId id, PlanDeCuentas dto);
    void delete(PlanDeCuentasId id);
}
