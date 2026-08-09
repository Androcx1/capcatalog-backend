package com.example.capcatalog.controller;

import com.example.capcatalog.dto.WearableOfferResponse;
import com.example.capcatalog.dto.WearableStatsResponse;
import com.example.capcatalog.service.WearableOfferService;
import com.example.capcatalog.service.WearableStatsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class WearableController {

    private final WearableOfferService wearableOfferService;
    private final WearableStatsService wearableStatsService;

    public WearableController(
            WearableOfferService wearableOfferService,
            WearableStatsService wearableStatsService
    ) {
        this.wearableOfferService = wearableOfferService;
        this.wearableStatsService = wearableStatsService;
    }

    @GetMapping("/api/wearable/oferta-actual")
    public WearableOfferResponse getCurrentOffer() {
        return wearableOfferService.getCurrentOffer();
    }

    @PostMapping("/api/wearable/oferta-aceptada")
    public WearableStatsResponse acceptOffer() {
        return wearableStatsService.aceptarOferta();
    }

    @PostMapping("/api/wearable/oferta-negada")
    public WearableStatsResponse rejectOffer() {
        return wearableStatsService.negarOferta();
    }

    @GetMapping("/api/wearable/estadisticas")
    public WearableStatsResponse getStats() {
        return wearableStatsService.obtenerEstadisticas();
    }

    @PostMapping("/api/wearable/estadisticas/reiniciar")
    public WearableStatsResponse resetStats() {
        return wearableStatsService.reiniciarEstadisticas();
    }
}