package com.empresa.contabilidad.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TiposCambioMonedaId implements Serializable {
    private LocalDateTime fecha;
    private Integer codMoneda;
}