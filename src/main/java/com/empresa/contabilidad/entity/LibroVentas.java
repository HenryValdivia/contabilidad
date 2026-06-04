package com.empresa.contabilidad.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "libro_ventas", schema = "contabilidad")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LibroVentas {
    @Id
    @Column(name = "cod_libro_ventas")
    private Integer codLibroVentas;

    @Column(name = "especificacion")
    private Integer especificacion;

    @Column(name = "numero")
    private Integer numero;

    @Column(name = "fecha_factura")
    private LocalDateTime fechaFactura;

    @Size(max = 50)
    @Column(name = "nro_factura")
    private String nroFactura;

    @Size(max = 100)
    @Column(name = "nro_autorizacion")
    private String nroAutorizacion;

    @Size(max = 2)
    @Column(name = "cod_estado")
    private String codEstado;

    @Column(name = "cod_cliente")
    private Integer codCliente;

    @Size(max = 50)
    @Column(name = "nit_cliente")
    private String nitCliente;

    @Size(max = 100)
    @Column(name = "nombre_cliente")
    private String nombreCliente;

    @Column(name = "monto_total")
    private Double montoTotal;

    @Column(name = "monto_ice_iehd_tasas")
    private Double montoIceIehdTasas;

    @Column(name = "monto_export_operac")
    private Double montoExportOperac;

    @Column(name = "monto_vtas_grv_tasa_cero")
    private Double montoVtasGrvTasaCero;

    @Column(name = "monto_subtotal")
    private Double montoSubtotal;

    @Column(name = "monto_dctos_bonific")
    private Double montoDctosBonific;

    @Column(name = "importe_base_credito_fiscal")
    private Double importeBaseCreditoFiscal;

    @Column(name = "debito_fiscal")
    private Double debitoFiscal;

    @Size(max = 100)
    @Column(name = "codigo_control")
    private String codigoControl;

    @Column(name = "cod_comprobante")
    private Integer codComprobante;

    @Column(name = "cod_gestion")
    private Integer codGestion;
}
