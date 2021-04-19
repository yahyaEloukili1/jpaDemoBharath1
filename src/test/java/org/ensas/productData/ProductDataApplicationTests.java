package org.ensas.productData;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.ensas.productData.dao.ProductRepository;
import org.ensas.productData.entities.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductDataApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	public void testCreate() {
		Product product = new Product();
		
		product.setName("laptop");
		product.setDesc("second laptop");
		product.setPrice(3000);
		productRepository.save(product);
		
	}
	@Test
	public void read() {
	
		Product p = productRepository.findById(1L).get();
		if(productRepository.existsById(p.getId())) {
			assertNotNull(p);
			assertEquals("ordinateur",p.getName());
		}
	
		
	}
	@Test
	public void update() {
		Product p = productRepository.findById(1L).get();
		p.setName("laptop");
		productRepository.save(p);
		
	}
	@Test
	public void delete() {
	
		if(productRepository.existsById(1L)) {
			productRepository.deleteById(1L);
		}
	}
	@Test
	public void count() {
	
		System.out.println("**********"+productRepository.count());
	}
	
	@Test
	public void findByName() {
	
		List<Product> products = productRepository.findByName("laptop");
		products.forEach(p->{
			System.out.println("*********************"+p.getName());
		});
	}
	@Test
	public void findByNameanddesc() {
	
		List<Product> products = productRepository.findByNameAndDesc("laptop","second laptop");
		products.forEach(p->{
			System.out.println("*********************"+p.getName());
		});
	}
	@Test
	public void findByPriceGreaterThan() {
	
		List<Product> products = productRepository.findByPriceGreaterThan(10);
		products.forEach(p->{
			System.out.println("*********************"+p.getName());
		});
	}
	
	@Test
	public void findByDescContains() {
	
		List<Product> products = productRepository.findByDescContains("lap");
		products.forEach(p->{
			System.out.println("*********************"+p.getName());
		});
	}
	@Test
	public void findByPriceBetween() {
	
		List<Product> products = productRepository.findByPriceBetween(10,5000);
		products.forEach(p->{
			System.out.println("*********************"+p.getName());
		});
	}
	@Test
	public void findByDescLike() {
	
		List<Product> products = productRepository.findByDescLike("%l%");
		products.forEach(p->{
			System.out.println("*********************"+p.getName());
		});
	}
	@Test
	public void findByIdIn() {
	
		List<Product> products = productRepository.findByIdIn(Arrays.asList(1000L,234L));
		products.forEach(p->{
			System.out.println("*********************"+p.getName());
		});
	}
	
	

}
