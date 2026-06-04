package com.empresa.contabilidad.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "empresa", schema = "public")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Empresa {

    @Id
    @Column(name = "cod_empresa")
    private Integer codEmpresa;

    @Column(name = "nombre_empresa")
    private String nombreEmpresa;
}
