package dev.dmohindru.springdata.compositekey.repos;

import dev.dmohindru.springdata.compositekey.entities.Customer;
import dev.dmohindru.springdata.compositekey.entities.CustomerId;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, CustomerId> {
}
