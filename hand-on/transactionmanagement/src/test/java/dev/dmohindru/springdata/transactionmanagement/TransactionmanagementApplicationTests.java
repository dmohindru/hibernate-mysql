package dev.dmohindru.springdata.transactionmanagement;

import dev.dmohindru.springdata.transactionmanagement.services.BankAccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TransactionmanagementApplicationTests {

	@Autowired
	private BankAccountService service;

	@Test
	void contextLoads() {
	}

	@Test
	public void testTransfer() {
		service.transfer(500);
	}



}
