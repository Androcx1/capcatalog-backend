package com.example.capcatalog.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PromocionAceptadaRequest(
        String idPromocion,
        String producto,
        String descripcion,
        String descuento,
        BigDecimal precioAnterior,
        BigDecimal precioOferta,
        LocalDate fechaCaducidad
) {
}