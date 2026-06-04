package com.empresa.contabilidad.entity;

import java.io.Serializable;

public class PlanDeCuentasId implements Serializable {
    private Integer codPlanCuenta;
    private Integer codGestion;

    public PlanDeCuentasId() {}

    public PlanDeCuentasId(Integer codPlanCuenta, Integer codGestion) {
        this.codPlanCuenta = codPlanCuenta;
        this.codGestion = codGestion;
    }

    public Integer getCodPlanCuenta() { return codPlanCuenta; }
    public void setCodPlanCuenta(Integer codPlanCuenta) { this.codPlanCuenta = codPlanCuenta; }
    public Integer getCodGestion() { return codGestion; }
    public void setCodGestion(Integer codGestion) { this.codGestion = codGestion; }
}
