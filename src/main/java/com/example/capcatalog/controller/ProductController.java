package com.example.capcatalog.controller;

import com.example.capcatalog.document.ProductDocument;
import com.example.capcatalog.service.ProductService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String home() {
        return "Backend de Cap Catalog funcionando correctamente";
    }

    @GetMapping("/api/productos")
    public List<ProductDocument> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/api/productos/buscar")
    public List<ProductDocument> searchProducts(@RequestParam(defaultValue = "") String texto) {
        return productService.searchProducts(texto);
    }

    @PostMapping("/api/productos/seed")
    public List<ProductDocument> seedProducts() {
        return productService.seedProducts();
    }
}