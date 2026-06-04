package com.empresa.contabilidad.repository;

import com.empresa.contabilidad.entity.ComprobanteDetalle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComprobanteDetalleRepository extends JpaRepository<ComprobanteDetalle, Integer> {
}
