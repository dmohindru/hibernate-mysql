package dev.dmohindru.springdata.associations;

import dev.dmohindru.springdata.associations.manytomany.entities.Programmer;
import dev.dmohindru.springdata.associations.manytomany.entities.Project;
import dev.dmohindru.springdata.associations.manytomany.repos.ProgrammerRepository;
import dev.dmohindru.springdata.associations.onetomany.entities.Customer;
import dev.dmohindru.springdata.associations.onetomany.entities.PhoneNumber;
import dev.dmohindru.springdata.associations.onetomany.repos.CustomerRepository;
import dev.dmohindru.springdata.associations.onetoone.entities.Licence;
import dev.dmohindru.springdata.associations.onetoone.entities.Person;
import dev.dmohindru.springdata.associations.onetoone.repos.LicenceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SpringBootTest
class AssociationsApplicationTests {

	@Autowired
	CustomerRepository repository;

	@Autowired
	ProgrammerRepository programmerRepository;

	@Autowired
	LicenceRepository licenceRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testCreateCustomer() {

		Customer customer = new Customer();
		customer.setName("John");


		PhoneNumber ph1 = new PhoneNumber();
		ph1.setNumber("1234567890");
		ph1.setType("cell");


		PhoneNumber ph2 = new PhoneNumber();
		ph2.setNumber("0987654321");
		ph2.setType("home");


		customer.addPhoneNumber(ph1);
		customer.addPhoneNumber(ph2);

		repository.save(customer);
	}

	@Test
	@Transactional
	public void testLoadCustomer() {
		Customer customer = repository.findById(3L).get();
		System.out.println("Customer: " + customer.getName());

		Set<PhoneNumber> numbers = customer.getNumbers();
		numbers.forEach(n -> System.out.println(n));
	}

	@Test
	@Transactional
	public void testUpdateCustomer() {
		Customer customer = repository.findById(3L).get();
		customer.setName("John Bush");

		Set<PhoneNumber> numbers = customer.getNumbers();
		numbers.forEach(n -> n.setType("cell"));
		repository.save(customer);
	}


	@Test
	public void testDelete() {
		repository.deleteById(3L);
	}

	@Test
	public void testmtmCreateRepository() {
		Programmer programmer = new Programmer();
		Project project = new Project();

		Set<Project> projects = new HashSet<>();


		programmer.setName("Dhruv");
		programmer.setSalary(10000);
		project.setName("Hibernate Project");

		projects.add(project);

		programmer.setProjects(projects);

		programmerRepository.save(programmer);

	}

	@Test
	public void testmtmFindProgrammer() {
		Programmer programmer = programmerRepository.findById(1l).get();
		System.out.println(programmer);
		System.out.println(programmer.getProjects());
	}

	@Test
	public void testOneToOneCreateLicence() {
		Licence licence = new Licence();
		licence.setType("CAR");
		licence.setValidFrom(new Date());
		licence.setValidTo(new Date());

		Person person = new Person();
		person.setFirstName("Dhruv");
		person.setLastName("Mohindru");
		person.setAge(35);

		licence.setPerson(person);

		licenceRepository.save(licence);

	}
}
