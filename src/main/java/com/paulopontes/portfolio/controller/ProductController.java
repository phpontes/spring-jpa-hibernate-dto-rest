package com.paulopontes.portfolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paulopontes.portfolio.dto.ProductDTO;
import com.paulopontes.portfolio.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping
	public List<ProductDTO> getAllProducts() {
		return productService.getAllProducts();
	}
	
	@GetMapping("/{id}")
	public ProductDTO getProductById(@PathVariable Long id) {
		return productService.getProductById(id);
	}
}