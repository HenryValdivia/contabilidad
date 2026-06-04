package com.empresa.contabilidad.service.impl;

import com.empresa.contabilidad.entity.LibroCompras;
import com.empresa.contabilidad.exception.ResourceNotFoundException;
import com.empresa.contabilidad.repository.LibroComprasRepository;
import com.empresa.contabilidad.service.LibroComprasService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LibroComprasServiceImpl implements LibroComprasService {

    private final LibroComprasRepository repo;

    public LibroComprasServiceImpl(LibroComprasRepository repo) { this.repo = repo; }

    @Override
    public List<LibroCompras> findAll() { return repo.findAll(); }

    @Override
    public LibroCompras findById(Integer id) { return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("LibroCompras not found: " + id)); }

    @Override
    public LibroCompras create(LibroCompras dto) { return repo.save(dto); }

    @Override
    public LibroCompras update(Integer id, LibroCompras dto) {
        LibroCompras existing = findById(id);
        dto.setCodLibroCompras(existing.getCodLibroCompras());
        return repo.save(dto);
    }

    @Override
    public void delete(Integer id) {
        LibroCompras existing = findById(id);
        repo.delete(existing);
    }
}
