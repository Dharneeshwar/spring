package com.cg.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.beans.Product;
import com.cg.dao.ProductRepository;
@Service
public class ProductServiceImpl implements ProductService {
@Autowired
ProductRepository prepo;
@Transactional
@Override
public Product addProduct(Product product) {
	// TODO Auto-generated method stub
	return prepo.save(product);

}

@Override
public Product findById(String productId) {
	// TODO Auto-generated method stub
	return prepo.findById(productId).get();

}

@Override
public List<Product> listByPriceRange(Double price1, Double price2) {
	// TODO Auto-generated method stub
	return prepo.listByPriceRange(price1, price2);

}
@Transactional
@Override
public Product updateProduct(Product product) {
	return prepo.save(product);

}
@Transactional
@Override
public void deleteById(String productId) {
	// TODO Auto-generated method stub
	prepo.deleteById(productId);

}

@Override
public List<Product> getProducts() {
	return prepo.findAll();

}

}
