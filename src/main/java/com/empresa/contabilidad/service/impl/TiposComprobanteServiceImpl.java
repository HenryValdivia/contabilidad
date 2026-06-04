package com.empresa.contabilidad.service.impl;

import com.empresa.contabilidad.entity.TiposComprobante;
import com.empresa.contabilidad.exception.ResourceNotFoundException;
import com.empresa.contabilidad.repository.TiposComprobanteRepository;
import com.empresa.contabilidad.service.TiposComprobanteService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TiposComprobanteServiceImpl implements TiposComprobanteService {

    private final TiposComprobanteRepository repo;

    public TiposComprobanteServiceImpl(TiposComprobanteRepository repo) { this.repo = repo; }

    @Override
    public List<TiposComprobante> findAll() { return repo.findAll(); }

    @Override
    public TiposComprobante findById(Integer id) { return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("TiposComprobante not found: " + id)); }

    @Override
    public TiposComprobante create(TiposComprobante dto) { return repo.save(dto); }

    @Override
    public TiposComprobante update(Integer id, TiposComprobante dto) {
        TiposComprobante existing = findById(id);
        dto.setCodTipoComprobante(existing.getCodTipoComprobante());
        return repo.save(dto);
    }

    @Override
    public void delete(Integer id) {
        TiposComprobante existing = findById(id);
        repo.delete(existing);
    }
}
