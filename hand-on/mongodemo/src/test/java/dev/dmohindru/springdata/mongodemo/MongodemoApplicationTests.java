package dev.dmohindru.springdata.mongodemo;

import dev.dmohindru.springdata.mongodemo.model.Product;
import dev.dmohindru.springdata.mongodemo.repos.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MongodemoApplicationTests {

	@Autowired
	ProductRepository repository;

	@Test
	void testSave() {
		Product product = new Product();
		product.setName("Macbook Pro");
		product.setPrice(2000f);

		Product savedProduct = repository.save(product);
		assertNotNull(savedProduct);
	}

	@Test
	public void testFindAll() {
		List<Product> products = repository.findAll();
		assertEquals(1, products.size());
	}

	@Test
	public void testDelete() {
		repository.deleteById("6021b9b5b4290538b68346c1");
		Optional<Product> product = repository.findById("6021b9b5b4290538b68346c1");
		assertTrue(product.isEmpty());
	}

	@Test
	public void testUpdate() {
		Product product = repository.findById("6021bc45f639643f5d19c58b").get();
		product.setName("Windows PC");
		product.setPrice(1500f);
		Product savedProduct = repository.save(product);
		assertEquals("Windows PC", savedProduct.getName());
	}

}
