package com.empresa.contabilidad.entity;

import java.io.Serializable;

public class ComprobanteId implements Serializable {
    private Integer codComprobante;
    private Integer codGestion;

    public ComprobanteId() {}

    public ComprobanteId(Integer codComprobante, Integer codGestion) {
        this.codComprobante = codComprobante;
        this.codGestion = codGestion;
    }

    // getters and setters (Lombok not used here because ID class should be simple)
    public Integer getCodComprobante() { return codComprobante; }
    public void setCodComprobante(Integer codComprobante) { this.codComprobante = codComprobante; }
    public Integer getCodGestion() { return codGestion; }
    public void setCodGestion(Integer codGestion) { this.codGestion = codGestion; }
}
