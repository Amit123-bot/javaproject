package com.ecommerce.ecommercebackend.service;


import com.ecommerce.ecommercebackend.model.Product;
import com.ecommerce.ecommercebackend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService  {

    @Autowired
    private ProductRepository repository;

    public void createProduct(Product product) {
         repository.save(product);
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Optional<Product> getProductById(String id) {
        return repository.findById(id);
    }

    public Product updateProduct(String id, Product product) {
        Product existing = repository.findById(id).orElseThrow();
        existing.setName(product.getName());
        existing.setDescription(product.getDescription());
        existing.setPrice(product.getPrice());
        return repository.save(existing);
    }

    public void deleteProduct(String id) {
        repository.deleteById(id);
    }
}