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
@Table(name = "estados_comprobantes", schema = "contabilidad")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EstadosComprobantes {

    @Id
    @Column(name = "cod_estado_comprobante")
    private Integer codEstadoComprobante;

    @Column(name = "nombre_estado_comprobante")
    private String nombreEstadoComprobante;
}
