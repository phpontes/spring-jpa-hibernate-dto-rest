package com.paulopontes.portfolio.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paulopontes.portfolio.dto.ProductDTO;
import com.paulopontes.portfolio.model.Product;
import com.paulopontes.portfolio.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<ProductDTO> getAllProducts() {
		List<Product> products = productRepository.findAll();
		return products.stream().map(this::toDTO).collect(Collectors.toList());
	}
	
	public ProductDTO getProductById(Long id) {
		return productRepository.findById(id).map(this::toDTO).orElse(null);
	}
	
	private ProductDTO toDTO(Product product) {
		ProductDTO dto = new ProductDTO();
		dto.setId(product.getId());
		dto.setName(product.getName());
		dto.setPrice(product.getPrice());
		return dto;
	}

	public ProductDTO createProduct(ProductDTO productDTO) {
		Product product = toEntity(productDTO);
		Product savedProduct = productRepository.save(product);
		return toDTO(savedProduct);
	}

	private Product toEntity(ProductDTO dto) {
		Product product = new Product();
		product.setId(dto.getId());
		product.setName(dto.getName());
		product.setPrice(dto.getPrice());
		return product;
	}

	public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
		return productRepository.findById(id).map(product -> {
			product.setName(productDTO.getName());
			product.setPrice(productDTO.getPrice());
			Product updatedProduct = productRepository.save(product);
			return toDTO(updatedProduct);
		}).orElse(null);
	}

	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
}
