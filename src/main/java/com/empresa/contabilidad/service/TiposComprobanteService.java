package com.empresa.contabilidad.service;

import com.empresa.contabilidad.entity.TiposComprobante;

import java.util.List;

public interface TiposComprobanteService {
    List<TiposComprobante> findAll();
    TiposComprobante findById(Integer id);
    TiposComprobante create(TiposComprobante dto);
    TiposComprobante update(Integer id, TiposComprobante dto);
    void delete(Integer id);
}
