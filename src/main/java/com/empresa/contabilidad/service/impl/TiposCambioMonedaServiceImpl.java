package com.empresa.contabilidad.service.impl;

import com.empresa.contabilidad.entity.TiposCambioMoneda;
import com.empresa.contabilidad.entity.TiposCambioMonedaId;
import com.empresa.contabilidad.exception.ResourceNotFoundException;
import com.empresa.contabilidad.repository.TiposCambioMonedaRepository;
import com.empresa.contabilidad.service.TiposCambioMonedaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TiposCambioMonedaServiceImpl implements TiposCambioMonedaService {

    private final TiposCambioMonedaRepository repo;

    public TiposCambioMonedaServiceImpl(TiposCambioMonedaRepository repo) { this.repo = repo; }

    @Override
    public List<TiposCambioMoneda> findAll() { return repo.findAll(); }

    @Override
    public TiposCambioMoneda findById(TiposCambioMonedaId id) {
        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("TiposCambioMoneda not found"));
    }

    @Override
    public TiposCambioMoneda create(TiposCambioMoneda dto) { return repo.save(dto); }

    @Override
    public TiposCambioMoneda update(TiposCambioMonedaId id, TiposCambioMoneda dto) {
        TiposCambioMoneda existing = findById(id);
        dto.setFecha(existing.getFecha());
        dto.setCodMoneda(existing.getCodMoneda());
        return repo.save(dto);
    }

    @Override
    public void delete(TiposCambioMonedaId id) {
        TiposCambioMoneda existing = findById(id);
        repo.delete(existing);
    }
}
