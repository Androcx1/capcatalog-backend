package com.example.capcatalog.service;

import com.example.capcatalog.document.ProductDocument;
import com.example.capcatalog.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDocument> getAllProducts() {
        List<ProductDocument> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

    public List<ProductDocument> searchProducts(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            return getAllProducts();
        }

        String searchText = texto.toLowerCase();

        return getAllProducts()
                .stream()
                .filter(product ->
                        product.getNombre().toLowerCase().contains(searchText) ||
                        product.getDescripcion().toLowerCase().contains(searchText) ||
                        product.getCategoria().toLowerCase().contains(searchText) ||
                        product.getColor().toLowerCase().contains(searchText) ||
                        product.getTipo().toLowerCase().contains(searchText)
                )
                .toList();
    }

    public List<ProductDocument> seedProducts() {
        productRepository.deleteAll();

        List<ProductDocument> products = List.of(
                new ProductDocument(
                        "1",
                        "New York Roja New Era",
                        "Gorra roja New Era con logo de New York, estilo urbano y visera plana.",
                        550,
                        "Snapback",
                        "Roja",
                        "Urbana",
                        true,
                        "15% OFF",
                        "/images/products/new york roja new era.png"
                ),
                new ProductDocument(
                        "2",
                        "Los Angeles Blanca New Era",
                        "Gorra blanca New Era con logo de Los Angeles y diseño clásico.",
                        620,
                        "Curva",
                        "Blanca",
                        "Deportiva",
                        true,
                        "",
                        "/images/products/los angeles blanca new era.png"
                ),
                new ProductDocument(
                        "3",
                        "AS Verde New Era",
                        "Gorra verde New Era con logo de Athletics, ideal para outfits urbanos.",
                        580,
                        "Snapback",
                        "Verde",
                        "Urbana",
                        false,
                        "Nueva",
                        "/images/products/as verde new era.png"
                ),
                new ProductDocument(
                        "4",
                        "Raptors Roja New Era",
                        "Gorra roja New Era de Raptors con diseño deportivo y llamativo.",
                        590,
                        "Trucker",
                        "Roja",
                        "Deportiva",
                        false,
                        "",
                        "/images/products/raptors roja new era.png"
                ),
                new ProductDocument(
                        "5",
                        "New York Azul Nubes 31 Hats",
                        "Gorra azul con diseño de nubes y detalles bordados de estilo premium.",
                        650,
                        "Premium",
                        "Azul",
                        "Elegante",
                        true,
                        "10% OFF",
                        "/images/products/new york azul nubes 31 hats.png"
                ),
                new ProductDocument(
                        "6",
                        "Águilas Azul New Era",
                        "Gorra azul New Era con logo de águilas, diseño limpio y deportivo.",
                        540,
                        "Curva",
                        "Azul",
                        "Deportiva",
                        false,
                        "",
                        "/images/products/aguilas azul new era.png"
                ),
                new ProductDocument(
                        "7",
                        "Logos Negra New Era",
                        "Gorra negra New Era con múltiples logos bordados alrededor del diseño.",
                        700,
                        "Edición Especial",
                        "Negra",
                        "Urbana",
                        true,
                        "Oferta",
                        "/images/products/logos negra new era.png"
                ),
                new ProductDocument(
                        "8",
                        "Sox Negra New Era",
                        "Gorra negra New Era de Sox con diseño clásico y visera plana.",
                        560,
                        "Snapback",
                        "Negra",
                        "Casual",
                        true,
                        "Top",
                        "/images/products/sox negra new era.png"
                )
        );

        productRepository.saveAll(products);

        return products;
    }
}