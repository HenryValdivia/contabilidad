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
@Table(name = "monedas", schema = "public")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Moneda {

    @Id
    @Column(name = "cod_moneda")
    private Integer codMoneda;

    @Column(name = "nombre_moneda")
    private String nombreMoneda;
}
