package com.empresa.contabilidad.repository;

import com.empresa.contabilidad.entity.TiposCambioMoneda;
import com.empresa.contabilidad.entity.TiposCambioMonedaId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TiposCambioMonedaRepository extends JpaRepository<TiposCambioMoneda, TiposCambioMonedaId> {
}
