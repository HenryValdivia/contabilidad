package com.empresa.contabilidad.dto;
import java.util.ArrayList;
import java.util.List;

import com.empresa.contabilidad.entity.Comprobante;
import com.empresa.contabilidad.entity.ComprobanteDetalle;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComprobanteDto {
    Comprobante comprobante = new Comprobante();
    List<ComprobanteDetalle> comprobanteDetalleList = new ArrayList<ComprobanteDetalle>();
}
