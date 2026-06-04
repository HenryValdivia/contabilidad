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
@Table(name = "gestiones", schema = "public")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Gestion {

    @Id
    @Column(name = "cod_gestion")
    private Integer codGestion;

    @Column(name = "nombre_gestion")
    private String nombreGestion;
}
