package com.example.capcatalog.service;

import com.example.capcatalog.document.ProductDocument;
import com.example.capcatalog.dto.WearableOfferResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WearableOfferService {

    private final ProductService productService;

    public WearableOfferService(ProductService productService) {
        this.productService = productService;
    }

    public WearableOfferResponse getCurrentOffer() {
        List<ProductDocument> products = productService.getAllProducts();

        ProductDocument offerProduct = products.stream()
                .filter(product -> product.getPromocion() != null)
                .filter(product -> !product.getPromocion().trim().isEmpty())
                .filter(product -> product.getPromocion().contains("%"))
                .findFirst()
                .orElse(null);

        if (offerProduct == null) {
            return new WearableOfferResponse(
                    "Oferta especial para smartwatch",
                    "Cap Catalog",
                    "Por el momento no hay una promoción activa. Revisa el catálogo para conocer los productos disponibles.",
                    "Sin promoción",
                    0,
                    0,
                    "Sin vigencia activa",
                    "No hay oferta disponible en este momento."
            );
        }

        Integer precioAnterior = offerProduct.getPrecio();
        Integer precioOferta = calcularPrecioOferta(precioAnterior, offerProduct.getPromocion());

        return new WearableOfferResponse(
                "Oferta especial para smartwatch",
                offerProduct.getNombre(),
                offerProduct.getDescripcion(),
                offerProduct.getPromocion(),
                precioAnterior,
                precioOferta,
                "Oferta válida por tiempo limitado",
                "Consulta esta promoción desde tu smartwatch sin abrir la página web."
        );
    }

    private Integer calcularPrecioOferta(Integer precio, String promocion) {
        if (precio == null || promocion == null) {
            return 0;
        }

        String numeroDescuento = promocion.replaceAll("[^0-9]", "");

        if (numeroDescuento.isEmpty()) {
            return precio;
        }

        int descuento = Integer.parseInt(numeroDescuento);
        double precioFinal = precio - (precio * (descuento / 100.0));

        return (int) Math.round(precioFinal);
    }
}