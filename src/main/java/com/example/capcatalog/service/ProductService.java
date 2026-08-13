package com.example.capcatalog.service;

import com.example.capcatalog.document.ProductDocument;
import com.example.capcatalog.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.text.Normalizer;
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

        String searchText = normalizeText(texto);

        String[] searchTokens = searchText
                .split("\\s+");

        return getAllProducts()
                .stream()
                .filter(product -> matchesProduct(product, searchTokens))
                .toList();
    }

    private boolean matchesProduct(ProductDocument product, String[] searchTokens) {
        String searchableText = normalizeText(
                safe(product.getNombre()) + " " +
                safe(product.getDescripcion()) + " " +
                safe(product.getCategoria()) + " " +
                safe(product.getColor()) + " " +
                safe(product.getTipo()) + " " +
                safe(product.getPromocion())
        );

        String[] productWords = searchableText.split("\\s+");

        for (String searchToken : searchTokens) {
            if (searchToken.isBlank()) {
                continue;
            }

            boolean tokenMatched = false;

            for (String productWord : productWords) {
                if (isSimilar(searchToken, productWord)) {
                    tokenMatched = true;
                    break;
                }
            }

            if (!tokenMatched) {
                return false;
            }
        }

        return true;
    }

    private boolean isSimilar(String searchToken, String productWord) {
        if (productWord.isBlank()) {
            return false;
        }

        if (productWord.contains(searchToken)) {
            return true;
        }

        if (productWord.startsWith(searchToken)) {
            return true;
        }

        if (searchToken.startsWith(productWord)) {
            return true;
        }

        int distance = levenshteinDistance(searchToken, productWord);
        int maxDistance = getMaxDistance(searchToken);

        return distance <= maxDistance;
    }

    private int getMaxDistance(String word) {
        int length = word.length();

        if (length <= 2) {
            return 0;
        }

        if (length <= 6) {
            return 2;
        }

        return 3;
    }

    private String normalizeText(String text) {
        String normalized = Normalizer
                .normalize(text.toLowerCase(), Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "");

        return normalized
                .replaceAll("[^a-z0-9\\s]", " ")
                .replaceAll("\\s+", " ")
                .trim();
    }

    private String safe(String value) {
        return value == null ? "" : value;
    }

    private int levenshteinDistance(String firstWord, String secondWord) {
        int[][] matrix = new int[firstWord.length() + 1][secondWord.length() + 1];

        for (int i = 0; i <= firstWord.length(); i++) {
            matrix[i][0] = i;
        }

        for (int j = 0; j <= secondWord.length(); j++) {
            matrix[0][j] = j;
        }

        for (int i = 1; i <= firstWord.length(); i++) {
            for (int j = 1; j <= secondWord.length(); j++) {
                int cost = firstWord.charAt(i - 1) == secondWord.charAt(j - 1)
                        ? 0
                        : 1;

                matrix[i][j] = Math.min(
                        Math.min(
                                matrix[i - 1][j] + 1,
                                matrix[i][j - 1] + 1
                        ),
                        matrix[i - 1][j - 1] + cost
                );
            }
        }

        return matrix[firstWord.length()][secondWord.length()];
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