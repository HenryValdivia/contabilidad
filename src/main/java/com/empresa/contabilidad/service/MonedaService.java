package com.empresa.contabilidad.service;

import com.empresa.contabilidad.entity.Moneda;

import java.util.List;

public interface MonedaService {
    List<Moneda> findAll();
    Moneda findById(Integer id);
    Moneda create(Moneda dto);
    Moneda update(Integer id, Moneda dto);
    void delete(Integer id);
}
