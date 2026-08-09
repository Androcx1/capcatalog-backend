package com.example.capcatalog.repository;

import com.example.capcatalog.document.ProductDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductRepository extends ElasticsearchRepository<ProductDocument, String> {
}