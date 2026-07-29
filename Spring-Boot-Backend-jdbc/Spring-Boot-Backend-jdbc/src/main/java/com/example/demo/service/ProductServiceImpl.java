package com.example.demo.service;

import com.example.demo.exception.DuplicateProductException;
import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProdById(Long prodId) {
        return productRepository.findById(prodId);
    }

    @Override
    public Optional <Product> getProdByName(String prodName) {
        return productRepository.findByName(prodName);
    }

    @Override
    public Product addProduct(Product product) {
        // Business rule: reject duplicate product names
        productRepository.findByName(product.prodName())
                .ifPresent(p -> { throw new DuplicateProductException(product.prodName()); });
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        // Business rule: product must exist
        productRepository.findById(product.prodId())
                .orElseThrow(() -> new ProductNotFoundException(product.prodId()));
        return productRepository.update(product);
    }

    @Override
    public void deleteProduct(Long prodId) {
        productRepository.findById(prodId)
                .orElseThrow(() -> new ProductNotFoundException(prodId));
        productRepository.deleteById(prodId);
    }
}
