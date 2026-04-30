package com.ecommerce.ecommercebackend.repository;

import com.ecommerce.ecommercebackend.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}