package dev.dmohindru.springdata.transactionmanagement.services;

import dev.dmohindru.springdata.transactionmanagement.entities.BankAccount;
import dev.dmohindru.springdata.transactionmanagement.repos.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankAccountServiceImpl implements BankAccountService{

    @Autowired
    private BankAccountRepository repository;

    @Override
    @Transactional
    public void transfer(int amount) {
        BankAccount obambaAccount = repository.findById(1).get();
        obambaAccount.setBal(obambaAccount.getBal() - amount);
        repository.save(obambaAccount);

        if(true)
            throw new RuntimeException();

        BankAccount trumpAccount = repository.findById(2).get();
        trumpAccount.setBal(trumpAccount.getBal() + amount);
        repository.save(trumpAccount);
    }
}
