package com.empresa.contabilidad.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "plan_de_cuentas", schema = "contabilidad")
@IdClass(PlanDeCuentasId.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlanDeCuentas {
    @Id
    @Column(name = "cod_plan_cuenta")
    private Integer codPlanCuenta;

    @Column(name = "cod_cuenta")
    private String codCuenta;

    @Column(name = "nombre_cuenta")
    private String nombreCuenta;

    @Column(name = "cod_moneda")
    private Integer codMoneda;

    @Column(name = "cod_estado_registro")
    private Integer codEstadoRegistro;

    @Column(name = "estado_cuentas")
    private Integer estadoCuentas;

    @Column(name = "ajustable")
    private Integer ajustable;

    @Column(name = "movimiento")
    private Integer movimiento;

    @Column(name = "costos")
    private Integer costos;

    @Column(name = "cod_plan_cuenta_padre")
    private Integer codPlanCuentaPadre;

    @Column(name = "nivel")
    private Integer nivel;

    @Column(name = "estado_cronos")
    private Integer estadoCronos;

    @Column(name = "cod_division")
    private Integer codDivision;

    @Column(name = "distribucion_gastos")
    private Integer distribucionGastos;

    @Column(name = "cod_estado_flujo")
    private Integer codEstadoFlujo;

    @Column(name = "cod_flujo")
    private Integer codFlujo;

    @Size(max = 5000)
    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "estado_promocion")
    private Integer estadoPromocion;

    @Column(name = "cod_estadoclientemedico")
    private Integer codEstadoclientemedico;

    @Id
    @Column(name = "cod_gestion")
    private Integer codGestion;

    @Column(name = "codigo_cuenta_sin")
    private String codigoCuentaSin;

    @Column(name = "nombre_cuenta_sin")
    private String nombreCuentaSin;
}
