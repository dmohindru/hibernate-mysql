package dev.dmohindru.springdata.jpqlandnativesql;

import dev.dmohindru.springdata.jpqlandnativesql.entities.Student;
import dev.dmohindru.springdata.jpqlandnativesql.repos.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@SpringBootTest
class JpqlandnativesqlApplicationTests {

	@Autowired
	StudentRepository repository;
	@Test
	void testStudentCreate() {
		Student student = new Student();
		student.setFirstName("John");
		student.setLastName("Ferguson");
		student.setScore(88);
		repository.save(student);

		Student student1 = new Student();
		student1.setFirstName("Bill");
		student1.setLastName("Gates");
		student1.setScore(75);

		repository.save(student1);
	}

	@Test
	void testFindAllStudents() {
		Pageable pageable = PageRequest.of(0, 5, Sort.Direction.DESC, "id");
		repository.findAllStudents(pageable).forEach(s -> System.out.println(s));
	}

	@Test
	void testFindAllStudentsPartial() {
		List<Object[]> partialData = repository.findAllStudentPartialData();

		for (Object[] objects: partialData) {
			System.out.println(objects[0]);
			System.out.println(objects[1]);
			System.out.println("--------");

		}

	}

	@Test
	void testFindAllStudentsByFirstName() {
		repository.findAllStudentsByFirstName("Bill").forEach(s -> System.out.println(s));
	}

	@Test
	void testFindAllStudentsByScores() {
		repository.findStudentsForGivenScores(80,90).forEach(s -> System.out.println(s));
	}

	@Test
	@Transactional
	@Rollback(false)
	void testDeleteStudentByFirstName() {
		repository.deleteStudentsByFirstName("Bill");
	}


	@Test
	public void testFindAllStudentNQ() {
		System.out.println(repository.findAllStudentNQ());
	}

	@Test
	public void testFindByFirstNameNQ() {
		System.out.println(repository.findFindFirstnameNQ("Bill"));
	}

	@Test
	public void testFindPartialDataNQ() {
		List<Object[]> values = repository.findStudentPartialDataNQ("Bill");

		values.forEach(obj -> {
			System.out.println("LastName: " + obj[0] + ", Scores: " + obj[1]);
		});
	}

}
