package org.ensas.productData.dao;

import java.util.List;

import org.ensas.productData.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

	public List<Product> findByName(String name);
	public List<Product> findByIdIn(List<Long> ids);
	public List<Product> findByDescContains(String mc);
	public List<Product> findByNameAndDesc(String name,String desc);
	public List<Product> findByDescLike(String desc);
	public List<Product> findByPriceGreaterThan(double price);
	public List<Product> findByPriceBetween(double price1,double price2);
}
