package com.empresa.contabilidad.service;

import com.empresa.contabilidad.entity.ComprobanteDetalle;

import java.util.List;

public interface ComprobanteDetalleService {
    List<ComprobanteDetalle> findAll();
    ComprobanteDetalle findById(Integer id);
    ComprobanteDetalle create(ComprobanteDetalle dto);
    ComprobanteDetalle update(Integer id, ComprobanteDetalle dto);
    void delete(Integer id);
}
