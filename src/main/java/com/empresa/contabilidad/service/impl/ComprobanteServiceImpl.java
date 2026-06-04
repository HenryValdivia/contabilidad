package com.empresa.contabilidad.service.impl;

import com.empresa.contabilidad.entity.Comprobante;
import com.empresa.contabilidad.entity.ComprobanteId;
import com.empresa.contabilidad.exception.ResourceNotFoundException;
import com.empresa.contabilidad.repository.ComprobanteRepository;
import com.empresa.contabilidad.service.ComprobanteService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ComprobanteServiceImpl implements ComprobanteService {

    private final ComprobanteRepository repo;

    public ComprobanteServiceImpl(ComprobanteRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Comprobante> findAll() { return repo.findAll(); }

    @Override
    public Comprobante findById(ComprobanteId id) {
        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Comprobante not found"));
    }

    @Override
    public Comprobante create(Comprobante dto) { return repo.save(dto); }

    @Override
    public Comprobante update(ComprobanteId id, Comprobante dto) {
        Comprobante existing = findById(id);
        dto.setCodComprobante(existing.getCodComprobante());
        dto.setCodGestion(existing.getCodGestion());
        return repo.save(dto);
    }

    @Override
    public void delete(ComprobanteId id) {
        Comprobante existing = findById(id);
        repo.delete(existing);
    }
}
