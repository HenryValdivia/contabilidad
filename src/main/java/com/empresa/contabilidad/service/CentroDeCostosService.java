package com.empresa.contabilidad.service;

import com.empresa.contabilidad.entity.CentroDeCostos;

import java.util.List;

public interface CentroDeCostosService {
    List<CentroDeCostos> findAll();
    CentroDeCostos findById(Integer id);
    CentroDeCostos create(CentroDeCostos dto);
    CentroDeCostos update(Integer id, CentroDeCostos dto);
    void delete(Integer id);
}
