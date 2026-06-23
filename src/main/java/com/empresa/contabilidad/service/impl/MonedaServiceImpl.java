package com.empresa.contabilidad.service.impl;

import com.empresa.contabilidad.entity.Moneda;
import com.empresa.contabilidad.exception.ResourceNotFoundException;
import com.empresa.contabilidad.repository.MonedaRepository;
import com.empresa.contabilidad.service.MonedaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MonedaServiceImpl implements MonedaService {

    private final MonedaRepository repo;

    public MonedaServiceImpl(MonedaRepository repo) { this.repo = repo; }

    @Override
    public List<Moneda> findAll() { return repo.findAll(); }

    @Override
    public Moneda findById(Integer id) { return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Moneda not found: " + id)); }

    @Override
    public Moneda create(Moneda dto) { return repo.save(dto); }

    @Override
    public Moneda update(Integer id, Moneda dto) {
        Moneda existing = findById(id);
        dto.setCodMoneda(existing.getCodMoneda());
        return repo.save(dto);
    }

    @Override
    public void delete(Integer id) {
        Moneda existing = findById(id);
        repo.delete(existing);
    }
}
