package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.cg.beans.Product;
import com.cg.service.ProductService;



@RestController
public class ProductController {
	@Autowired
	ProductService pService;
		@Autowired
		Product product;
		@PostMapping("/add/{productId}/{name}/{model}/{price}")
		public Product addEmployee(@PathVariable String productId,@PathVariable String name,@PathVariable String model,@PathVariable Double price) {
			product.setProductId(productId);
			product.setName(name);
			product.setModel(model);
			product.setPrice(price);
			Product savedEmp=pService.addProduct(product);
			return savedEmp;
		}//http://localhost:8083/addobject,body, raw,post,test-json

		@PostMapping(value="/addproduct",consumes= {MediaType.APPLICATION_JSON_VALUE})
		public Product addProduct(@RequestBody Product product ) {
			Product savedProduct=pService.addProduct(product);
			return savedProduct;
		} 
		//http://localhost:8083/add/priya/bangalore/40000/trainer
	//http://localhost:8083/viewall

		@GetMapping("/viewall")
		public List<Product>viewAll(){
		return pService.getProducts();
}
		@DeleteMapping("/deletebyid/{productId}")
		public String deleteById(@PathVariable String productId) {
			pService.deleteById(productId);
			return productId+" deleted"	;
		}
		@GetMapping("/findbyid/{productId}")
		public Product findById(@PathVariable String productId) {
			return pService.findById(productId);
		}
		@GetMapping("/pricerange/{price1}/{price2}")
		public List<Product> salaryRangePath(@PathVariable Double price1,@PathVariable Double price2){
			return pService.listByPriceRange(price1, price2);
		}

		@PutMapping(value="/updateobject",consumes= {MediaType.APPLICATION_JSON_VALUE})
		public Product updateProduct(@RequestBody Product product) {
			Product savedProduct=pService.updateProduct(product);
			return savedProduct;
		}





}
