package com.empresa.contabilidad.repository;

import com.empresa.contabilidad.entity.LibroCompras;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroComprasRepository extends JpaRepository<LibroCompras, Integer> {
}
