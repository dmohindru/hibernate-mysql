package dev.dmohindru.customer.repos;

import dev.dmohindru.customer.entities.Customer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    List<Customer> findByNameAndEmail(String name, String email);

    List<Customer> findByEmailLike(String email);

    List<Customer> findByEmailLike(String email, Pageable pageable);

    List<Customer> findByIdIn(List<Integer> ids);

    @Modifying
    @Query("update Customer c set c.email = :newEmail where c.id = :id and c.email = :email")
    void updateCustomerEmail(@Param("id")Integer id, @Param("email")String email, @Param("newEmail")String newEmail);
}
