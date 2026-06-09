package com.empresa.contabilidad.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ComprobanteResumenDto {
    private Integer codComprobante;
    private Integer codEmpresa;
    private String nombreEmpresa;
    private Integer codGestion;
    private String nombreGestion;
    private Integer codMoneda;
    private String nombreMoneda;
    private Integer codPersonal;
    private Integer codEstadoComprobante;
    private String nombreEstadoComprobante;
    private Integer codTipoComprobante;
    private LocalDateTime fechaComprobante;
    private Integer nroComprobante;
    private String nroCheque;
    private String nroFactura;
    private String glosaComprobante;
    private Integer codTipoComprobanteGenerado;
    private Integer estadoSistema;
    private Integer codEmisionCheqhe;
    private LocalDateTime fechaSistema;
    private String descrMontoTotal;
    private int page = 0;
    private int size = 10;
}
