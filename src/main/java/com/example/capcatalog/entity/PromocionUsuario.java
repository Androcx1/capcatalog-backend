package com.example.capcatalog.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;

@Entity
@Table(name = "promociones_usuario")
public class PromocionUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_promocion", nullable = false)
    private String idPromocion;

    @Column(nullable = false)
    private String producto;

    @Column
    private String descripcion;

    @Column
    private String descuento;

    @Column(name = "precio_anterior")
    private BigDecimal precioAnterior;

    @Column(name = "precio_oferta")
    private BigDecimal precioOferta;

    @Column(nullable = false)
    private String decision;

    @Column(name = "fecha_decision")
    private OffsetDateTime fechaDecision;

    @Column(name = "fecha_caducidad")
    private LocalDate fechaCaducidad;

    @Column(nullable = false)
    private String estado;

    @Column(name = "created_at")
    private OffsetDateTime createdAt;

    public PromocionUsuario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public BigDecimal getPrecioAnterior() {
        return precioAnterior;
    }

    public void setPrecioAnterior(BigDecimal precioAnterior) {
        this.precioAnterior = precioAnterior;
    }

    public BigDecimal getPrecioOferta() {
        return precioOferta;
    }

    public void setPrecioOferta(BigDecimal precioOferta) {
        this.precioOferta = precioOferta;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public OffsetDateTime getFechaDecision() {
        return fechaDecision;
    }

    public void setFechaDecision(OffsetDateTime fechaDecision) {
        this.fechaDecision = fechaDecision;
    }

    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }
}