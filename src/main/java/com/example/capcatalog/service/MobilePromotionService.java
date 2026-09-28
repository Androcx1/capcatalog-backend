package com.example.capcatalog.service;

import com.example.capcatalog.document.ProductDocument;
import com.example.capcatalog.dto.MobilePromotionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
public class MobilePromotionService {

    private final ProductService productService;

    public MobilePromotionService(ProductService productService) {
        this.productService = productService;
    }

    public MobilePromotionResponse getPromotionById(String idPromocion) {

        if (!"PROMO-001".equalsIgnoreCase(idPromocion)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Promoción no encontrada"
            );
        }

        List<ProductDocument> products = productService.getAllProducts();

        ProductDocument product = products.stream()
                .filter(item -> item.getPromocion() != null)
                .filter(item -> !item.getPromocion().isBlank())
                .filter(item -> item.getPromocion().contains("%"))
                .findFirst()
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "No existe una promoción activa"
                        )
                );

        Integer precioAnterior = product.getPrecio();

        Integer precioOferta = calcularPrecioOferta(
                precioAnterior,
                product.getPromocion()
        );

        LocalDate fechaCaducidad = LocalDate.of(
                2026,
                10,
                15
        );

        String estado = LocalDate.now().isAfter(fechaCaducidad)
                ? "CADUCADA"
                : "VIGENTE";

        return new MobilePromotionResponse(
                "PROMO-001",
                product.getNombre(),
                product.getDescripcion(),
                product.getPromocion(),
                precioAnterior,
                precioOferta,
                fechaCaducidad.toString(),
                estado,
                product.getImagen()
        );
    }

    private Integer calcularPrecioOferta(
            Integer precio,
            String promocion
    ) {

        if (precio == null || promocion == null) {
            return 0;
        }

        String numeroDescuento =
                promocion.replaceAll("[^0-9]", "");

        if (numeroDescuento.isBlank()) {
            return precio;
        }

        int descuento =
                Integer.parseInt(numeroDescuento);

        double precioFinal =
                precio - (precio * (descuento / 100.0));

        return (int) Math.round(precioFinal);
    }
}