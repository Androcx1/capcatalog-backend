package com.example.capcatalog.service;

import com.example.capcatalog.dto.WearableStatsResponse;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class WearableStatsService {

    private final AtomicInteger ofertasAceptadas = new AtomicInteger(0);
    private final AtomicInteger ofertasNegadas = new AtomicInteger(0);

    public WearableStatsResponse aceptarOferta() {
        ofertasAceptadas.incrementAndGet();

        return obtenerEstadisticas();
    }

    public WearableStatsResponse negarOferta() {
        ofertasNegadas.incrementAndGet();

        return obtenerEstadisticas();
    }

    public WearableStatsResponse obtenerEstadisticas() {
        return new WearableStatsResponse(
                ofertasAceptadas.get(),
                ofertasNegadas.get()
        );
    }

    public WearableStatsResponse reiniciarEstadisticas() {
        ofertasAceptadas.set(0);
        ofertasNegadas.set(0);

        return obtenerEstadisticas();
    }
}