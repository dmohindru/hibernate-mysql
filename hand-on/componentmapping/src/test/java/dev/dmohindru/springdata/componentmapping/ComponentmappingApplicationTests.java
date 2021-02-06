package dev.dmohindru.springdata.componentmapping;

import dev.dmohindru.springdata.componentmapping.entities.Address;
import dev.dmohindru.springdata.componentmapping.entities.Employee;
import dev.dmohindru.springdata.componentmapping.repos.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ComponentmappingApplicationTests {

	@Autowired
	EmployeeRepository repository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testCreate() {

		// create new Address object
		Address address = new Address();
		address.setCity("Westmead");
		address.setStreetaddress("Mons Road");
		address.setCountry("Australia");
		address.setState("NSW");
		address.setZipcode("2145");

		// create new Employee object
		Employee employee = new Employee();
		employee.setId(123);
		employee.setName("Dhruv");
		employee.setAddress(address);

		repository.save(employee);
	}

}
