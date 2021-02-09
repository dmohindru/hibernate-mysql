package dev.dmohindru.springdata.compositekey;

import dev.dmohindru.springdata.compositekey.entities.Customer;
import dev.dmohindru.springdata.compositekey.entities.CustomerId;
import dev.dmohindru.springdata.compositekey.repos.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CompositekeyApplicationTests {

	@Autowired
	private CustomerRepository customerRepository;

	@Test
	void testSaveCustomer() {
		Customer customer = new Customer();
		CustomerId customerId = new CustomerId();
		customerId.setId(234);
		customerId.setEmail("dmoh@dm.com");
		customer.setName("Test Test");
		customer.setCustomerId(customerId);
		customerRepository.save(customer);
	}

}
