package com.paulopontes.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paulopontes.portfolio.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
}
