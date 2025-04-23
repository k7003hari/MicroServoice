package com.cts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	public abstract List<Product> findByproductPriceBetween(int initialPrice, int finalPrice);
//	public abstract List<Product> getAllProductsBetween(int initialPrice, int finalPrice);

	public abstract List<Product> findByproductCategory(String Category);
//	public abstract List<Product> getAllProductsByCategory(String category);

	public abstract List<Product> findByProductPriceGreaterThan(int price);
//	public abstract List<Product> getAllProductsAbove(int Price);
}