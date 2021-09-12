package com.spring2.cloud.service.product;


import com.spring2.cloud.common.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final com.spring2.cloud.service.product.ProductService productService;

    private static final Function<com.spring2.cloud.service.product.Product, ProductDto> mapper = p -> new ProductDto(p.getId(), p.getTitle(), p.getPrice());

    @GetMapping
    public List<ProductDto> findAll() {
        return productService.findAll().stream().map(mapper).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ProductDto findById(@PathVariable Long id) {
        return mapper.apply(productService.findById(id).get());
    }
}
