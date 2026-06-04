package com.empresa.contabilidad.service;

import com.empresa.contabilidad.entity.Comprobante;
import com.empresa.contabilidad.entity.ComprobanteId;

import java.util.List;

public interface ComprobanteService {
    List<Comprobante> findAll();
    Comprobante findById(ComprobanteId id);
    Comprobante create(Comprobante dto);
    Comprobante update(ComprobanteId id, Comprobante dto);
    void delete(ComprobanteId id);
}
