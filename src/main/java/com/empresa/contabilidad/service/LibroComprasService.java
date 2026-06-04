package com.empresa.contabilidad.service;

import com.empresa.contabilidad.entity.LibroCompras;

import java.util.List;

public interface LibroComprasService {
    List<LibroCompras> findAll();
    LibroCompras findById(Integer id);
    LibroCompras create(LibroCompras dto);
    LibroCompras update(Integer id, LibroCompras dto);
    void delete(Integer id);
}
