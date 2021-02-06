package dev.dmohindru.springdata.product;

import dev.dmohindru.springdata.product.entities.Product;
import dev.dmohindru.springdata.product.repos.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
class ProductdataApplicationTests {

	@Autowired
	ProductRepository repository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testCreate() {
		Product product = new Product();
		product.setId(1);
		product.setName("IPhone X");
		product.setDesc("Awesome product");
		product.setPrice(1000d);

		repository.save(product);
	}

	@Test
	public void testRead() {
		Optional<Product> product = repository.findById(1);

		// if no product found return null
		assertNotNull(product.orElse(null));
		assertEquals("IPhone X", product.get().getName());
		System.out.println(">>>>>>>>>>>>>>>>>>>>" + product.get().getDesc());
	}

	@Test
	public void testUpdate() {
		Product product = repository.findById(1).get();
		product.setPrice(2000d);
		repository.save(product);
	}

	@Test
	public void testDelete() {
		if (repository.existsById(1)) {
			System.out.println("Deleting Product");
			repository.deleteById(1);
		}

	}

	@Test
	public void testCount() {
		System.out.println("Total Records>>>>>>>>>>" + repository.count());

	}

	@Test
	public void testFindByName() {
		List<Product> products = repository.findByName("IWatch");
		products.forEach(p -> System.out.println(p.getPrice()));
	}

	@Test
	public void testFindByNameAndDesc() {
		List<Product> products = repository.findByNameAndDesc("TV", "from samsung");
		products.forEach(p -> System.out.println(p.getPrice()));
	}

	@Test
	public void testFindByPriceGreaterThan() {
		List<Product> products = repository.findByPriceGreaterThan(1000);
		products.forEach(p -> System.out.println(p.getName()));
	}

	@Test
	public void testFindByDescContains() {
		List<Product> products = repository.findByDescContains("apple");
		products.forEach(p -> System.out.println(p.getName()));
	}

	@Test
	public void testFindByPriceBetween() {
		List<Product> products = repository.findByPriceBetween(500d, 2000d);
		products.forEach(p -> System.out.println(p.getName()));
	}

	@Test
	public void testFindByDescLike() {
		List<Product> products = repository.findByDescLike("%LG%");
		products.forEach(p -> System.out.println(p.getName()));
	}

	@Test
	public void testFindByIdsIn() {
		Pageable pageable = PageRequest.of(1, 2);
		List<Product> products = repository.findByIdIn(Arrays.asList(1,2,3, 4), pageable);
		products.forEach(p -> System.out.println(p.getName()));
	}

	@Test
	public void testFindAllPaging() {
		Pageable pageable = PageRequest.of(1, 2);
		Page<Product> page = repository.findAll(pageable);

		page.forEach(p -> System.out.println(p.getName()));
	}

	@Test
	public void testFindAllSorting() {
//		Iterable<Product> products = repository.findAll(Sort.by(Sort.Direction.ASC, "name", "price"));
//		products.forEach(p -> System.out.println(p.getName()));

		repository
				.findAll(Sort.by(new Sort.Order(null, "name")
						,new Sort.Order(Sort.Direction.DESC, "price")))
				.forEach(p-> System.out.println(p.getName()));
	}

	@Test
	public void testFindAllPagingAndSorting() {

		Pageable pageable = PageRequest.of(0, 2, Sort.Direction.DESC, "name", "price");
		repository.findAll(pageable).forEach(p -> System.out.println(p.getName()));

	}

}
