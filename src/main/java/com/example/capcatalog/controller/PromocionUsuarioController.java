package com.example.capcatalog.controller;

import com.example.capcatalog.dto.PromocionAceptadaRequest;
import com.example.capcatalog.entity.PromocionUsuario;
import com.example.capcatalog.service.PromocionUsuarioService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mobile/promociones")
@CrossOrigin(origins = "*")
public class PromocionUsuarioController {

    private final PromocionUsuarioService service;

    public PromocionUsuarioController(
            PromocionUsuarioService service
    ) {
        this.service = service;
    }

    @PostMapping("/aceptar")
    public ResponseEntity<PromocionUsuario> aceptarPromocion(
            @RequestBody PromocionAceptadaRequest request
    ) {

        PromocionUsuario guardada =
                service.aceptarPromocion(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(guardada);
    }
}