package com.empresa.contabilidad.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class TiposCambioMonedaId implements Serializable {
    private LocalDateTime fecha;
    private Integer codMoneda;

    public TiposCambioMonedaId() {}

    public TiposCambioMonedaId(LocalDateTime fecha, Integer codMoneda) {
        this.fecha = fecha;
        this.codMoneda = codMoneda;
    }

    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
    public Integer getCodMoneda() { return codMoneda; }
    public void setCodMoneda(Integer codMoneda) { this.codMoneda = codMoneda; }
}
