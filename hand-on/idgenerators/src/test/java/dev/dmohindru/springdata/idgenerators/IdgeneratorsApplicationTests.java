package dev.dmohindru.springdata.idgenerators;

import dev.dmohindru.springdata.idgenerators.entities.Employee;
import dev.dmohindru.springdata.idgenerators.repos.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IdgeneratorsApplicationTests {

	@Autowired
	EmployeeRepository repository;

	@Test
	void testAdd() {
		Employee employee = new Employee();
		employee.setName("John");
		repository.save(employee);

	}

}
