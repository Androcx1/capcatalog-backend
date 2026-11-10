package com.example.capcatalog.service;

import com.example.capcatalog.dto.PromocionAceptadaRequest;
import com.example.capcatalog.dto.PromocionRechazadaRequest;
import com.example.capcatalog.entity.PromocionUsuario;
import com.example.capcatalog.repository.PromocionUsuarioRepository;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Service
public class PromocionUsuarioService {

    private final PromocionUsuarioRepository repository;

    public PromocionUsuarioService(
            PromocionUsuarioRepository repository
    ) {
        this.repository = repository;
    }

    public PromocionUsuario aceptarPromocion(
            PromocionAceptadaRequest request
    ) {

        PromocionUsuario promocion =
                new PromocionUsuario();

        promocion.setIdPromocion(
                request.idPromocion()
        );

        promocion.setProducto(
                request.producto()
        );

        promocion.setDescripcion(
                request.descripcion()
        );

        promocion.setDescuento(
                request.descuento()
        );

        promocion.setPrecioAnterior(
                request.precioAnterior()
        );

        promocion.setPrecioOferta(
                request.precioOferta()
        );

        promocion.setFechaCaducidad(
                request.fechaCaducidad()
        );

        promocion.setDecision(
                "ACEPTADA"
        );

        promocion.setFechaDecision(
                OffsetDateTime.now()
        );

        promocion.setCreatedAt(
                OffsetDateTime.now()
        );

        promocion.setEstado(
                calcularEstado(
                        request.fechaCaducidad()
                )
        );

        return repository.save(promocion);
    }


    public PromocionUsuario rechazarPromocion(
            PromocionRechazadaRequest request
    ) {

        PromocionUsuario promocion =
                new PromocionUsuario();

        promocion.setIdPromocion(
                request.idPromocion()
        );

        promocion.setProducto(
                request.producto()
        );

        promocion.setDescripcion(
                request.descripcion()
        );

        promocion.setDescuento(
                request.descuento()
        );

        promocion.setPrecioAnterior(
                request.precioAnterior()
        );

        promocion.setPrecioOferta(
                request.precioOferta()
        );

        promocion.setFechaCaducidad(
                request.fechaCaducidad()
        );

        promocion.setDecision(
                "RECHAZADA"
        );

        promocion.setFechaDecision(
                OffsetDateTime.now()
        );

        promocion.setCreatedAt(
                OffsetDateTime.now()
        );

        promocion.setEstado(
                calcularEstado(
                        request.fechaCaducidad()
                )
        );

        return repository.save(promocion);
    }


    private String calcularEstado(
            LocalDate fechaCaducidad
    ) {

        if (
                fechaCaducidad != null &&
                fechaCaducidad.isBefore(
                        LocalDate.now()
                )
        ) {

            return "CADUCADA";

        }

        return "VIGENTE";
    }
}