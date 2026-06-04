package com.empresa.contabilidad.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "libro_compras", schema = "contabilidad")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LibroCompras {
    @Id
    @Column(name = "cod_libro_compras")
    private Integer codLibroCompras;

    @Column(name = "cod_comprobante")
    private Integer codComprobante;

    @Column(name = "cod_proveedor")
    private Integer codProveedor;

    @Size(max = 255)
    @Column(name = "nro_factura")
    private String nroFactura;

    @Size(max = 255)
    @Column(name = "nro_orden")
    private String nroOrden;

    @Column(name = "fecha_libro")
    private LocalDateTime fechaLibro;

    @Column(name = "total_factura")
    private Double totalFactura;

    @Column(name = "ice")
    private Double ice;

    @Column(name = "importes_excentos")
    private Double importesExcentos;

    @Column(name = "credito_fiscal")
    private Double creditoFiscal;

    @Size(max = 255)
    @Column(name = "nro_autorizacion")
    private String nroAutorizacion;

    @Column(name = "cod_tipo_documento_libro_compras")
    private Integer codTipoDocumentoLibroCompras;

    @Size(max = 255)
    @Column(name = "nro_poliza")
    private String nroPoliza;

    @Size(max = 255)
    @Column(name = "nit_proveedor")
    private String nitProveedor;

    @Size(max = 255)
    @Column(name = "nombre_proveedor")
    private String nombreProveedor;

    @Column(name = "cod_gestion")
    private Integer codGestion;
}
