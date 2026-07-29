package com.example.demo.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Long prodId) {
        super("Product with id " + prodId + " not found");
    }
}
