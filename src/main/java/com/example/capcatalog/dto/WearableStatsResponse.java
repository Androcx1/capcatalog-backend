package com.example.capcatalog.dto;

public class WearableStatsResponse {

    private Integer ofertasAceptadas;
    private Integer ofertasNegadas;

    public WearableStatsResponse() {
    }

    public WearableStatsResponse(Integer ofertasAceptadas, Integer ofertasNegadas) {
        this.ofertasAceptadas = ofertasAceptadas;
        this.ofertasNegadas = ofertasNegadas;
    }

    public Integer getOfertasAceptadas() {
        return ofertasAceptadas;
    }

    public void setOfertasAceptadas(Integer ofertasAceptadas) {
        this.ofertasAceptadas = ofertasAceptadas;
    }

    public Integer getOfertasNegadas() {
        return ofertasNegadas;
    }

    public void setOfertasNegadas(Integer ofertasNegadas) {
        this.ofertasNegadas = ofertasNegadas;
    }
}