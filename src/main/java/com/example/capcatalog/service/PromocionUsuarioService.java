package com.example.capcatalog.service;

import com.example.capcatalog.dto.PromocionAceptadaRequest;
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

        // La decisión la controla el backend
        promocion.setDecision("ACEPTADA");

        // Fecha automática del servidor
        promocion.setFechaDecision(
                OffsetDateTime.now()
        );

        promocion.setCreatedAt(
                OffsetDateTime.now()
        );

        // Estado dependiendo de la fecha de caducidad
        if (
                request.fechaCaducidad() != null &&
                request.fechaCaducidad().isBefore(LocalDate.now())
        ) {

            promocion.setEstado("CADUCADA");

        } else {

            promocion.setEstado("VIGENTE");

        }

        return repository.save(promocion);
    }
}