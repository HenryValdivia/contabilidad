package com.empresa.contabilidad.service;

import com.empresa.contabilidad.entity.LibroVentas;

import java.util.List;

public interface LibroVentasService {
    List<LibroVentas> findAll();
    LibroVentas findById(Integer id);
    LibroVentas create(LibroVentas dto);
    LibroVentas update(Integer id, LibroVentas dto);
    void delete(Integer id);
}
