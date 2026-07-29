package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return service.getProducts();
    }

    @GetMapping("/product/{prodId}")
    public ResponseEntity<Product> getProdById(@PathVariable Long prodId) {
        return service.getProdById(prodId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // TODO-1 : Implement a GET endpoint to retrieve a product by its name
    @GetMapping("/product/name/{prodName}")
    public ResponseEntity<Product> getProdByName(@PathVariable String prodName) {
        return service.getProdByName(prodName)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/product")
    public Product addProduct(@RequestBody Product product) {
        return service.addProduct(product);
    }

    @PutMapping("/product/{prodId}")
    public Product updateProduct(@PathVariable Long prodId, @RequestBody Product product) {
        return service.updateProduct(new Product(prodId, product.prodName(), product.price()));
    }

    @DeleteMapping("/product/{prodId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long prodId) {
        service.deleteProduct(prodId);
        return ResponseEntity.noContent().build();
    }
}
