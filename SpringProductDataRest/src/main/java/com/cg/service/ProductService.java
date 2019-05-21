package com.cg.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.cg.beans.Product;

public interface ProductService {
	public Product addProduct(Product product);
	public Product findById(String productId);
	public List<Product> listByPriceRange(Double price1 ,Double price2);
	public Product updateProduct(Product product);
	public void deleteById(String productId);

	public List<Product> getProducts();
	
}
