package com.empresa.contabilidad.repository;

import com.empresa.contabilidad.entity.PlanDeCuentas;
import com.empresa.contabilidad.entity.PlanDeCuentasId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanDeCuentasRepository extends JpaRepository<PlanDeCuentas, PlanDeCuentasId> {
}
