package com.empresa.contabilidad.service;

import com.empresa.contabilidad.entity.TiposCambioMoneda;
import com.empresa.contabilidad.entity.TiposCambioMonedaId;

import java.util.List;

public interface TiposCambioMonedaService {
    List<TiposCambioMoneda> findAll();
    TiposCambioMoneda findById(TiposCambioMonedaId id);
    TiposCambioMoneda create(TiposCambioMoneda dto);
    TiposCambioMoneda update(TiposCambioMonedaId id, TiposCambioMoneda dto);
    void delete(TiposCambioMonedaId id);
}
