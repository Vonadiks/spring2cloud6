package com.spring2.cloud.service.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<com.spring2.cloud.service.product.Product, Long> {
}
