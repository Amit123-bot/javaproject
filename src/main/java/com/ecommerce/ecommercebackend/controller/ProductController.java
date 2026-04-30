package com.ecommerce.ecommercebackend.controller;

import com.ecommerce.ecommercebackend.model.Product;
import com.ecommerce.ecommercebackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    // CREATE PRODUCT
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        service.createProduct(product);
        return product;
    }

    // GET ALL PRODUCTS
    @GetMapping
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    // GET PRODUCT BY ID
    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable String id) {
        return service.getProductById(id);
    }

    // UPDATE PRODUCT
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable String id, @RequestBody Product product) {
        return service.updateProduct(id, product);
    }

    // DELETE PRODUCT
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable String id) {
        service.deleteProduct(id);
        return "Product deleted successfully";
    }
}