package com.platform.ecommerce.repository;
 
import com.platform.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
 
public interface ProductRepository extends JpaRepository<Product, Long> {}