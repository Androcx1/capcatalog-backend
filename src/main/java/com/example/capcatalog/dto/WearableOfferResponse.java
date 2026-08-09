package com.example.capcatalog.dto;

public class WearableOfferResponse {

    private String titulo;
    private String producto;
    private String descripcion;
    private String descuento;
    private Integer precioAnterior;
    private Integer precioOferta;
    private String vigencia;
    private String mensaje;

    public WearableOfferResponse() {
    }

    public WearableOfferResponse(
            String titulo,
            String producto,
            String descripcion,
            String descuento,
            Integer precioAnterior,
            Integer precioOferta,
            String vigencia,
            String mensaje
    ) {
        this.titulo = titulo;
        this.producto = producto;
        this.descripcion = descripcion;
        this.descuento = descuento;
        this.precioAnterior = precioAnterior;
        this.precioOferta = precioOferta;
        this.vigencia = vigencia;
        this.mensaje = mensaje;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getProducto() {
        return producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getDescuento() {
        return descuento;
    }

    public Integer getPrecioAnterior() {
        return precioAnterior;
    }

    public Integer getPrecioOferta() {
        return precioOferta;
    }

    public String getVigencia() {
        return vigencia;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }

    public void setPrecioAnterior(Integer precioAnterior) {
        this.precioAnterior = precioAnterior;
    }

    public void setPrecioOferta(Integer precioOferta) {
        this.precioOferta = precioOferta;
    }

    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}