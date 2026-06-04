package com.empresa.contabilidad.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "comprobante", schema = "contabilidad")
@IdClass(ComprobanteId.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comprobante {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "seqComprobante")
    @SequenceGenerator(name = "seqComprobante", sequenceName = "seqComprobante", schema = "contabilidad", allocationSize = 1)
    @Column(name = "cod_comprobante")
    private Integer codComprobante;

    @Id
    @Column(name = "cod_gestion")
    private Integer codGestion;

    @Column(name = "cod_empresa")
    private Integer codEmpresa;

    @Column(name = "cod_moneda")
    private Integer codMoneda;

    @Column(name = "cod_personal")
    private Integer codPersonal;

    @Column(name = "cod_estado_comprobante")
    private Integer codEstadoComprobante;

    @Column(name = "cod_tipo_comprobante")
    private Integer codTipoComprobante;

    @Column(name = "fecha_comprobante")
    private LocalDateTime fechaComprobante;

    @Column(name = "nro_comprobante")
    private Integer nroComprobante;

    @Size(max = 120)
    @Column(name = "nro_cheque")
    private String nroCheque;

    @Size(max = 120)
    @Column(name = "nro_factura")
    private String nroFactura;

    @Size(max = 200)
    @Column(name = "glosa")
    private String glosa;

    @Column(name = "cod_tipo_comprobante_generado")
    private Integer codTipoComprobanteGenerado;

    @Column(name = "estado_sistema")
    private Integer estadoSistema;

    @Column(name = "cod_emision_cheqhe")
    private Integer codEmisionCheqhe;

    @Column(name = "fecha_sistema")
    private LocalDateTime fechaSistema;

    @Size(max = 200)
    @Column(name = "descr_monto_total")
    private String descrMontoTotal;
}
