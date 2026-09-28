package com.example.capcatalog.dto;

public class MobilePromotionResponse {

    private String idPromocion;
    private String producto;
    private String descripcion;
    private String descuento;
    private Integer precioAnterior;
    private Integer precioOferta;
    private String fechaCaducidad;
    private String estado;
    private String imagen;

    public MobilePromotionResponse() {
    }

    public MobilePromotionResponse(
            String idPromocion,
            String producto,
            String descripcion,
            String descuento,
            Integer precioAnterior,
            Integer precioOferta,
            String fechaCaducidad,
            String estado,
            String imagen
    ) {
        this.idPromocion = idPromocion;
        this.producto = producto;
        this.descripcion = descripcion;
        this.descuento = descuento;
        this.precioAnterior = precioAnterior;
        this.precioOferta = precioOferta;
        this.fechaCaducidad = fechaCaducidad;
        this.estado = estado;
        this.imagen = imagen;
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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}