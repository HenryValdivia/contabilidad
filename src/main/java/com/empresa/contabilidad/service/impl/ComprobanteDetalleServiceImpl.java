package com.empresa.contabilidad.service.impl;

import com.empresa.contabilidad.entity.ComprobanteDetalle;
import com.empresa.contabilidad.exception.ResourceNotFoundException;
import com.empresa.contabilidad.repository.ComprobanteDetalleRepository;
import com.empresa.contabilidad.service.ComprobanteDetalleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ComprobanteDetalleServiceImpl implements ComprobanteDetalleService {

    private final ComprobanteDetalleRepository repo;

    public ComprobanteDetalleServiceImpl(ComprobanteDetalleRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<ComprobanteDetalle> findAll() { return repo.findAll(); }

    @Override
    public ComprobanteDetalle findById(Integer id) {
        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("ComprobanteDetalle not found: " + id));
    }

    @Override
    public ComprobanteDetalle create(ComprobanteDetalle dto) { return repo.save(dto); }

    @Override
    public ComprobanteDetalle update(Integer id, ComprobanteDetalle dto) {
        ComprobanteDetalle existing = findById(id);
        dto.setCodComprobanteDetalle(existing.getCodComprobanteDetalle());
        return repo.save(dto);
    }

    @Override
    public void delete(Integer id) {
        ComprobanteDetalle existing = findById(id);
        repo.delete(existing);
    }
}
