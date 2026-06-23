package com.empresa.contabilidad.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.contabilidad.entity.Moneda;

public interface MonedaRepository extends JpaRepository<Moneda, Integer> {
}
