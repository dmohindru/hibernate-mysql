package dev.dmohindru.springdata.associations.onetomany.repos;

import dev.dmohindru.springdata.associations.onetomany.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
