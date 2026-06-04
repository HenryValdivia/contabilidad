package com.empresa.contabilidad.service.impl;

import com.empresa.contabilidad.entity.CentroDeCostos;
import com.empresa.contabilidad.exception.ResourceNotFoundException;
import com.empresa.contabilidad.repository.CentroDeCostosRepository;
import com.empresa.contabilidad.service.CentroDeCostosService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CentroDeCostosServiceImpl implements CentroDeCostosService {

    private final CentroDeCostosRepository repo;

    public CentroDeCostosServiceImpl(CentroDeCostosRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<CentroDeCostos> findAll() {
        return repo.findAll();
    }

    @Override
    public CentroDeCostos findById(Integer id) {
        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("CentroDeCostos not found: " + id));
    }

    @Override
    public CentroDeCostos create(CentroDeCostos dto) {
        return repo.save(dto);
    }

    @Override
    public CentroDeCostos update(Integer id, CentroDeCostos dto) {
        CentroDeCostos existing = findById(id);
        dto.setCodCentroCostos(existing.getCodCentroCostos());
        return repo.save(dto);
    }

    @Override
    public void delete(Integer id) {
        CentroDeCostos existing = findById(id);
        repo.delete(existing);
    }
}
