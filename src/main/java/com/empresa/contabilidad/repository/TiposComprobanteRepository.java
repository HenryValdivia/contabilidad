package com.empresa.contabilidad.repository;

import com.empresa.contabilidad.entity.TiposComprobante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TiposComprobanteRepository extends JpaRepository<TiposComprobante, Integer> {
}
