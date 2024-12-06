package com.paulopontes.portfolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paulopontes.portfolio.dto.ProductDTO;
import com.paulopontes.portfolio.service.ProductService;

import jakarta.validation.Valid;

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
	
	@GetMapping("/price/{price}")
	public List<ProductDTO> getProductsByPrice(@PathVariable Double price) {
		return productService.getProductsByPrice(price);
	}
	
	@PostMapping
	public ProductDTO createProduct(@Valid @RequestBody ProductDTO productDTO) {
		return productService.createProduct(productDTO);
	}
	
	@PutMapping("/{id}")
	public ProductDTO updateProduct(@PathVariable Long id, @Valid @RequestBody ProductDTO productDTO) {
		return productService.updateProduct(id, productDTO);
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
	}
}
