package com.paulopontes.portfolio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.paulopontes.portfolio.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	@Query("SELECT p FROM Product p WHERE p.price < :price")
	List<Product> findAllByPriceLessThan(@Param("price") Double price);
}
