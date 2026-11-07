package com.example.capcatalog.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "accepted_promotions")
public class AcceptedPromotionDocument {

    @Id
    private String idPromocion;

    private String producto;
    private String descripcion;
    private String descuento;
    private Integer precioAnterior;
    private Integer precioOferta;
    private String fechaAceptacion;
    private String fechaCaducidad;
    private String estado;

    public AcceptedPromotionDocument() {
    }

    public AcceptedPromotionDocument(
            String idPromocion,
            String producto,
            String descripcion,
            String descuento,
            Integer precioAnterior,
            Integer precioOferta,
            String fechaAceptacion,
            String fechaCaducidad,
            String estado
    ) {
        this.idPromocion = idPromocion;
        this.producto = producto;
        this.descripcion = descripcion;
        this.descuento = descuento;
        this.precioAnterior = precioAnterior;
        this.precioOferta = precioOferta;
        this.fechaAceptacion = fechaAceptacion;
        this.fechaCaducidad = fechaCaducidad;
        this.estado = estado;
    }

    public String getIdPromocion() {
        return idPromocion;
    }

    public void setIdPromocion(String idPromocion) {
        this.idPromocion = idPromocion;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescuento() {
        return descuento;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }

    public Integer getPrecioAnterior() {
        return precioAnterior;
    }

    public void setPrecioAnterior(Integer precioAnterior) {
        this.precioAnterior = precioAnterior;
    }

    public Integer getPrecioOferta() {
        return precioOferta;
    }

    public void setPrecioOferta(Integer precioOferta) {
        this.precioOferta = precioOferta;
    }

    public String getFechaAceptacion() {
        return fechaAceptacion;
    }

    public void setFechaAceptacion(String fechaAceptacion) {
        this.fechaAceptacion = fechaAceptacion;
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}