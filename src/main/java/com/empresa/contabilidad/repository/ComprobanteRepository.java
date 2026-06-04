package com.empresa.contabilidad.repository;

import com.empresa.contabilidad.entity.Comprobante;
import com.empresa.contabilidad.entity.ComprobanteId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComprobanteRepository extends JpaRepository<Comprobante, ComprobanteId> {
}
