package dev.dmohindru.springdata.idgenerators.repos;

import dev.dmohindru.springdata.idgenerators.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
