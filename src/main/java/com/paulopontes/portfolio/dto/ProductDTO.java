package com.paulopontes.portfolio.dto;

import com.paulopontes.portfolio.model.Product;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class ProductDTO {

	private Long id;
	
	@NotBlank(message = "oi m8, the name cannot be blank")
	private String name;
	
	@Min(value = 0, message = "Sire, the price must be positive. You're not buying debts, are you?")
	private Double price;
	
	public ProductDTO() {
	}

	public ProductDTO(Long id, String name, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	public ProductDTO toDTO(Product product) {
	    ProductDTO dto = new ProductDTO();
	    dto.setId(product.getId());
	    dto.setName(product.getName());
	    dto.setPrice(product.getPrice());
	    return dto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
