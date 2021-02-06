package dev.dmohindru.customer;

import dev.dmohindru.customer.entities.Address;
import dev.dmohindru.customer.entities.Customer;
import dev.dmohindru.customer.repos.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CustomerDataApplicationTests {

	@Autowired
	CustomerRepository repository;

	@Test
	void contextLoads() {
	}

	@Test
	void testAdd() {
		Customer customer = new Customer();
		customer.setName("Dhruv");
		customer.setEmail("dmohindru@yahoo.com");
		repository.save(customer);

		Customer customer1 = new Customer();
		customer1.setName("Poonam");
		customer1.setEmail("mohindru.poonam@gmail.com");
		repository.save(customer1);
	}

	@Test
	void testRead() {
		Customer customer = repository.findById(Integer.valueOf(1)).get();
		assertNotNull(customer);
		assertEquals("Dhruv", customer.getName());
	}

	@Test
	void testUpdate() {
		Customer customer = repository.findById(Integer.valueOf(1)).get();
		customer.setName("Dhruv Mohindru");
		repository.save(customer);
	}

	@Test
	void testDelete() {
		if (repository.existsById(Integer.valueOf(1))) {
			System.out.println("Deleting customers");
			repository.deleteById(Integer.valueOf(1));
		}
	}

	@Test
	void testFindByNameAndEmail() {
		List<Customer> customers = repository.findByNameAndEmail("Dhruv", "dmohindru@yahoo.com");
		customers.forEach(c -> System.out.println("Customer Details: " + c.getName() + ", " + c.getEmail()));
	}

	@Test
	void testFindByEmailLike() {
		List<Customer> customers = repository.findByEmailLike("%yah%");
		customers.forEach(c -> System.out.println("Customer Details: " + c.getName() + ", " + c.getEmail()));
	}

	@Test
	void testFindByIdsIn() {
		List<Customer> customers = repository.findByIdIn(Arrays.asList(1,2,4));
		customers.forEach(c -> System.out.println("Customer Details: " + c.getName() + ", " + c.getEmail()));
	}

	@Test
	@Transactional
	@Rollback(value = false)
	void testUpdateCustomerEmail() {
		repository.updateCustomerEmail(1, "dmohindru@yahoo.com", "dmohindru@gmail.com");
	}

	@Test
	void testFindByEmailLikePageable() {
		Pageable pageable = PageRequest.of(2, 5, Sort.Direction.DESC, "name");
		repository.findByEmailLike("%.%", pageable).forEach(c -> System.out.println(c));
	}

	@Test
	void testAddCustomer() {
		Address address = new Address();
		address.setStreetaddress("Mons Road");
		address.setCity("Westmead");
		address.setState("NSW");
		address.setZipcode("2145");
		address.setCountry("Australia");

		Customer customer = new Customer();
		customer.setName("Dhruv Mohindru");
		customer.setEmail("dmohindru@gmail.com");
		customer.setAddress(address);


		repository.save(customer);


	}


}
