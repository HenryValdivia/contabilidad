package com.empresa.contabilidad.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "centro_de_costos", schema = "contabilidad")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CentroDeCostos {
    @Id
    @Column(name = "cod_centro_costos")
    private Integer codCentroCostos;

    @Column(name = "cod_tipo_centro_costos")
    private Integer codTipoCentroCostos;

    @Size(max = 200)
    @Column(name = "nombre_centro_costos")
    private String nombreCentroCostos;

    @Column(name = "cod_estado_registro")
    private Integer codEstadoRegistro;

    @Size(max = 3)
    @Column(name = "codigo")
    private String codigo;

    @Size(max = 3)
    @Column(name = "abreviatura")
    private String abreviatura;
}
