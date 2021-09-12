package com.spring2.cloud.service.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<com.spring2.cloud.service.product.Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<com.spring2.cloud.service.product.Product> findById(Long id) {
        return productRepository.findById(id);
    }
}
