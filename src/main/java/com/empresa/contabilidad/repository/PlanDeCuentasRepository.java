package com.empresa.contabilidad.repository;

import com.empresa.contabilidad.entity.PlanDeCuentas;
import com.empresa.contabilidad.entity.PlanDeCuentasId;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanDeCuentasRepository extends JpaRepository<PlanDeCuentas, PlanDeCuentasId> {
    // Busca registros donde el código o el nombre contengan el texto ingresado (Búsqueda flexible)
    List<PlanDeCuentas> findByCodCuentaStartingWithIgnoreCaseAndNombreCuentaStartingWithIgnoreCase( //findByCodCuentaContainingIgnoreCaseOrNombreCuentaContainingIgnoreCase busca por código o nombre de cuenta, sin importar mayúsculas o minúsculas
            String codCuenta, 
            String nombreCuenta
    );
}
