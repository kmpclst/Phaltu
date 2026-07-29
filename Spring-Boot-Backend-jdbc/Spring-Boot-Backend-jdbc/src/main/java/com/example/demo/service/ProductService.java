package com.example.demo.service;

import com.example.demo.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getProducts();

    Optional<Product> getProdById(Long prodId);

    Optional<Product> getProdByName(String prodName);

    Product addProduct(Product product);

    Product updateProduct(Product product);

    void deleteProduct(Long prodId);
}
