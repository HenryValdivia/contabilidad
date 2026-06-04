package com.empresa.contabilidad.repository;

import com.empresa.contabilidad.entity.CentroDeCostos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CentroDeCostosRepository extends JpaRepository<CentroDeCostos, Integer> {
}
