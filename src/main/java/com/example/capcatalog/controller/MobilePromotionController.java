package com.example.capcatalog.controller;

import com.example.capcatalog.dto.MobilePromotionResponse;
import com.example.capcatalog.service.MobilePromotionService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mobile/promociones")
@CrossOrigin(origins = "*")
public class MobilePromotionController {

    private final MobilePromotionService mobilePromotionService;

    public MobilePromotionController(
            MobilePromotionService mobilePromotionService
    ) {
        this.mobilePromotionService =
                mobilePromotionService;
    }

    @GetMapping("/{idPromocion}")
    public MobilePromotionResponse getPromotion(
            @PathVariable String idPromocion
    ) {
        return mobilePromotionService
                .getPromotionById(idPromocion);
    }
}