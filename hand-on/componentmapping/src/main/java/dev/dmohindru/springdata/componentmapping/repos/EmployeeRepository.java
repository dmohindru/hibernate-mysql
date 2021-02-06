package dev.dmohindru.springdata.componentmapping.repos;

import dev.dmohindru.springdata.componentmapping.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
