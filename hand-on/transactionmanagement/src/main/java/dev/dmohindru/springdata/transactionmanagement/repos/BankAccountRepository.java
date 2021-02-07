package dev.dmohindru.springdata.transactionmanagement.repos;

import dev.dmohindru.springdata.transactionmanagement.entities.BankAccount;
import org.springframework.data.repository.CrudRepository;

public interface BankAccountRepository  extends CrudRepository<BankAccount, Integer> {

}
