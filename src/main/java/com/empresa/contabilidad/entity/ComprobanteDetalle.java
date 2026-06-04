package com.empresa.contabilidad.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "comprobante_detalle", schema = "contabilidad")
@IdClass(ComprobanteDetalleId.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComprobanteDetalle {
    @Id
    @Column(name = "cod_comprobante")
    private Integer codComprobante;

    @Id
    @Column(name = "cod_comprobante_detalle")
    private Integer codComprobanteDetalle;

    @Column(name = "cod_plan_cuenta")
    private Integer codPlanCuenta;

    @Column(name = "cod_regional")
    private Integer codRegional;

    @Column(name = "cod_producto")
    private Integer codProducto;

    @Column(name = "cod_linea")
    private Integer codLinea;

    @Column(name = "cod_centro_costos")
    private Integer codCentroCostos;

    @Column(name = "debe")
    private Double debe;

    @Column(name = "haber")
    private Double haber;

    @Size(max = 120)
    @Column(name = "glosa")
    private String glosa;

    @Column(name = "debesus")
    private Double debesus;

    @Column(name = "habersus")
    private Double habersus;

    @Column(name = "cod_orden_compra")
    private Integer codOrdenCompra;

    @Column(name = "cod_gestion")
    private Integer codGestion;
}
