package com.cg.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.cg.beans.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product,String> {
	
	
	public Optional<Product> findById(String product);
	@Query("select e from Product e where e.price between ?1 and ?2")
	public List<Product> listByPriceRange(Double price1 ,Double price22);
	public void deleteById(String productId);
	

	}


