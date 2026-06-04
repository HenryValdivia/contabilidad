package com.empresa.contabilidad.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComprobanteDetalleId implements Serializable {
    private Integer codComprobante;
    private Integer codComprobanteDetalle;
}
