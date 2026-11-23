package com.example.capcatalog.controller;

import com.example.capcatalog.dto.PromocionAceptadaRequest;
import com.example.capcatalog.dto.PromocionRechazadaRequest;
import com.example.capcatalog.entity.PromocionUsuario;
import com.example.capcatalog.service.PromocionUsuarioService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    /*
     * OBTENER TODAS LAS DECISIONES
     *
     * GET /api/mobile/promociones
     */
    @GetMapping
    public ResponseEntity<List<PromocionUsuario>> obtenerTodas() {

        List<PromocionUsuario> promociones =
                service.obtenerTodas();

        return ResponseEntity.ok(
                promociones
        );
    }


    /*
     * ACEPTAR PROMOCIÓN
     *
     * POST /api/mobile/promociones/aceptar
     */
    @PostMapping("/aceptar")
    public ResponseEntity<PromocionUsuario> aceptarPromocion(
            @RequestBody PromocionAceptadaRequest request
    ) {

        PromocionUsuario guardada =
                service.aceptarPromocion(
                        request
                );

        return ResponseEntity
                .status(
                        HttpStatus.CREATED
                )
                .body(
                        guardada
                );
    }


    /*
     * RECHAZAR PROMOCIÓN
     *
     * POST /api/mobile/promociones/rechazar
     */
    @PostMapping("/rechazar")
    public ResponseEntity<PromocionUsuario> rechazarPromocion(
            @RequestBody PromocionRechazadaRequest request
    ) {

        PromocionUsuario guardada =
                service.rechazarPromocion(
                        request
                );

        return ResponseEntity
                .status(
                        HttpStatus.CREATED
                )
                .body(
                        guardada
                );
    }
}