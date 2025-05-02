package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.exception.ProductNotFound;
import com.cts.model.Product;
import com.cts.service.ProductService;

@RestController@RequestMapping("/products") // http://localhost:8080/products
public class ProductController {
	@Autowired
	ProductService service;

	@GetMapping("/getMsg") // http://localhost:8080/products/getMsg
	public String sayHello() {
		return "Sandeep is an Excellent Trainer give him increment";
	}

	@PostMapping("/saveproduct") // http://localhost:8080/products/saveproduct
	public String insertProduct(@RequestBody @Validated Product product) {
		return service.saveProduct(product);
	}

	@PutMapping("/updateproduct") // http://localhost:8080/products/updateproduct
	public Product updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);
	}

	@GetMapping("/getproduct/{pid}") // http://localhost:8080/products/getproduct/1
	public Product fetchProduct(@PathVariable("pid") int productId) throws ProductNotFound {
		return service.getProduct(productId);
	}

	@DeleteMapping("/removeproduct/{pid}") // http://localhost:8080/products/removeproduct/1
	public String removeProduct(@PathVariable("pid") int productId) {
		return service.removeProduct(productId);
	}

	@GetMapping("/getAllProduct") // http://localhost:8080/products/getAllProduct
	public List<Product> getAllProduct() {
		return service.getAllProducts();
	}

	@GetMapping("/getAllProductBetween/{p1}/{p2}") // http://localhost:1111/products/getAllProductBetween/1/2
	public List<Product> getAllProductsBetween(@PathVariable("p1") int initialPrice,@PathVariable("p2") int FinalPrice) {
		return service.getAllProductsBetween(initialPrice, FinalPrice);
	}

	@GetMapping("/getAllProductCategory/{category}") // http://localhost:1111/products/getproduct/1
	public List<Product> getAllProductsByCategory(@PathVariable("category") String category) {
		return service.getAllProductsByCategory(category);
	}

	// controller level exception handling...
//	@ExceptionHandler(exception = ProductNotFound.class,produces = "Product Id Is Invalid")
//	public void handleProductNotFound()
//	{
//		
//	}

}