package com.example.capcatalog.service;

import com.example.capcatalog.document.AcceptedPromotionDocument;
import com.example.capcatalog.repository.AcceptedPromotionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AcceptedPromotionService {

    private final AcceptedPromotionRepository repository;

    public AcceptedPromotionService(
            AcceptedPromotionRepository repository
    ) {
        this.repository = repository;
    }

    public AcceptedPromotionDocument save(
            AcceptedPromotionDocument promotion
    ) {

        promotion.setFechaAceptacion(
                LocalDateTime.now().toString()
        );

        promotion.setEstado("ACEPTADA");

        return repository.save(promotion);
    }

    public boolean exists(String idPromocion) {
        return repository.existsById(idPromocion);
    }

    public Optional<AcceptedPromotionDocument> findById(
            String idPromocion
    ) {
        return repository.findById(idPromocion);
    }

    public List<AcceptedPromotionDocument> findAll() {

        List<AcceptedPromotionDocument> promotions =
                new ArrayList<>();

        repository.findAll().forEach(promotions::add);

        return promotions;
    }
}