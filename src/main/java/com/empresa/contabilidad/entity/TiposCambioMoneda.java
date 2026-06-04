package com.empresa.contabilidad.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "tipos_cambio_moneda", schema = "contabilidad")
@IdClass(TiposCambioMonedaId.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TiposCambioMoneda {
    @Id
    @Column(name = "fecha")
    private LocalDateTime fecha;

    @Id
    @Column(name = "cod_moneda")
    private Integer codMoneda;

    @Column(name = "monto")
    private Double monto;
}
