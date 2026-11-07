package com.example.capcatalog.repository;

import com.example.capcatalog.document.AcceptedPromotionDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface AcceptedPromotionRepository
        extends ElasticsearchRepository<AcceptedPromotionDocument, String> {
}