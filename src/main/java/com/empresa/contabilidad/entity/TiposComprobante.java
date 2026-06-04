package com.empresa.contabilidad.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tipos_comprobante", schema = "contabilidad")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TiposComprobante {
    @Id
    @Column(name = "cod_tipo_comprobante")
    private Integer codTipoComprobante;

    @Column(name = "cod_estado_registro")
    private Integer codEstadoRegistro;

    @Size(max = 180)
    @Column(name = "nombre_tipo_comprobante")
    private String nombreTipoComprobante;

    @Size(max = 120)
    @Column(name = "obs_tipo_comprobante")
    private String obsTipoComprobante;

    @Size(max = 4)
    @Column(name = "abreviatura")
    private String abreviatura;
}
