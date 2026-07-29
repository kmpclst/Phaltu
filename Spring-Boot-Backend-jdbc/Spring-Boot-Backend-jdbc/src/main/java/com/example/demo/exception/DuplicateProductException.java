package com.example.demo.exception;

public class DuplicateProductException extends RuntimeException {
    public DuplicateProductException(String prodName) {
        super("Product with name '" + prodName + "' already exists");
    }
}
