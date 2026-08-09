package com.example.capcatalog.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "cap_products")
public class ProductDocument {

    @Id
    private String id;

    private String nombre;
    private String descripcion;
    private Integer precio;
    private String categoria;
    private String color;
    private String tipo;
    private Boolean destacado;
    private String promocion;
    private String imagen;

    public ProductDocument() {
    }

    public ProductDocument(String id, String nombre, String descripcion, Integer precio, String categoria, String color, String tipo, Boolean destacado, String promocion, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
        this.color = color;
        this.tipo = tipo;
        this.destacado = destacado;
        this.promocion = promocion;
        this.imagen = imagen;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Integer getPrecio() {
        return precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getColor() {
        return color;
    }

    public String getTipo() {
        return tipo;
    }

    public Boolean getDestacado() {
        return destacado;
    }

    public String getPromocion() {
        return promocion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDestacado(Boolean destacado) {
        this.destacado = destacado;
    }

    public void setPromocion(String promocion) {
        this.promocion = promocion;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}