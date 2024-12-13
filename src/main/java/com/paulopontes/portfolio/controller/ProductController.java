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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Operation(summary = "Get all products", description = "Retrieve a list of all products in the database.")
	@ApiResponse(responseCode = "200", description = "Successfully retrieved list.")
	@GetMapping
	public List<ProductDTO> getAllProducts() {
		return productService.getAllProducts();
	}

	@Operation(summary = "Get product by ID", description = "Retrieve details of a specific product by its ID.")
	@ApiResponse(responseCode = "200", description = "Successfully retrieved the product.")
	@ApiResponse(responseCode = "404", description = "Product not found.")
	@GetMapping("/{id}")
	public ProductDTO getProductById(@PathVariable Long id) {
		return productService.getProductById(id);
	}

	@Operation(summary = "Get products by price", description = "Retrieve a list of products with the specified price.")
	@ApiResponse(responseCode = "200", description = "Successfully retrieved the list of products.")
	@ApiResponse(responseCode = "404", description = "No products found with the specified price.")
	@GetMapping("/price/{price}")
	public List<ProductDTO> getProductsByPrice(@PathVariable Double price) {
		return productService.getProductsByPrice(price);
	}

	@Operation(summary = "Create a new product", description = "Add a new product to the database.")
	@ApiResponse(responseCode = "201", description = "Product successfully created.")
	@PostMapping
	public ProductDTO createProduct(@Valid @RequestBody ProductDTO productDTO) {
		return productService.createProduct(productDTO);
	}

	@Operation(summary = "Update an existing product", description = "Update the details of an existing product by its ID.")
    @ApiResponse(responseCode = "200", description = "Product successfully updated.")
    @ApiResponse(responseCode = "404", description = "Product not found.")
    @ApiResponse(responseCode = "400", description = "Invalid request body.")
	@PutMapping("/{id}")
	public ProductDTO updateProduct(@PathVariable Long id, @Valid @RequestBody ProductDTO productDTO) {
		return productService.updateProduct(id, productDTO);
	}

    @Operation(summary = "Delete a product", description = "Delete a product from the database by its ID.")
    @ApiResponse(responseCode = "204", description = "Product successfully deleted.")
    @ApiResponse(responseCode = "404", description = "Product not found.")
	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
	}
}
