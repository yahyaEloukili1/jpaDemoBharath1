package org.ensas.productData;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
		
		product.setName("ordinateur");
		product.setDesc("second laptop");
		product.setPrice(3000);
		productRepository.save(product);
		
	}
	@Test
	public void read() {
	
		Product p = productRepository.findById(1).get();
		if(productRepository.existsById(p.getId())) {
			assertNotNull(p);
			assertEquals("ordinateur",p.getName());
		}
	
		
	}
	@Test
	public void update() {
		Product p = productRepository.findById(1).get();
		p.setName("laptop");
		productRepository.save(p);
		
	}
	@Test
	public void delete() {
	
		if(productRepository.existsById(1)) {
			productRepository.deleteById(1);
		}
	}
	@Test
	public void count() {
	
		System.out.println("**********"+productRepository.count());
	}
	
	

}
