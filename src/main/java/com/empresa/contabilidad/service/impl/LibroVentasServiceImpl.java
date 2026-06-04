package com.empresa.contabilidad.service.impl;

import com.empresa.contabilidad.entity.LibroVentas;
import com.empresa.contabilidad.exception.ResourceNotFoundException;
import com.empresa.contabilidad.repository.LibroVentasRepository;
import com.empresa.contabilidad.service.LibroVentasService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LibroVentasServiceImpl implements LibroVentasService {

    private final LibroVentasRepository repo;

    public LibroVentasServiceImpl(LibroVentasRepository repo) { this.repo = repo; }

    @Override
    public List<LibroVentas> findAll() { return repo.findAll(); }

    @Override
    public LibroVentas findById(Integer id) { return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("LibroVentas not found: " + id)); }

    @Override
    public LibroVentas create(LibroVentas dto) { return repo.save(dto); }

    @Override
    public LibroVentas update(Integer id, LibroVentas dto) {
        LibroVentas existing = findById(id);
        dto.setCodLibroVentas(existing.getCodLibroVentas());
        return repo.save(dto);
    }

    @Override
    public void delete(Integer id) {
        LibroVentas existing = findById(id);
        repo.delete(existing);
    }
}
