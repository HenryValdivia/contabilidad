package com.empresa.contabilidad.repository;

import com.empresa.contabilidad.entity.LibroVentas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroVentasRepository extends JpaRepository<LibroVentas, Integer> {
}
