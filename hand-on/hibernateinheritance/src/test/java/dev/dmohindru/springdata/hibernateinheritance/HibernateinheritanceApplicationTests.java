package dev.dmohindru.springdata.hibernateinheritance;

import dev.dmohindru.springdata.hibernateinheritance.entities.Cheque;
import dev.dmohindru.springdata.hibernateinheritance.entities.CreditCard;
import dev.dmohindru.springdata.hibernateinheritance.repos.PaymentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HibernateinheritanceApplicationTests {

	@Autowired
	PaymentRepository repository;

	@Test
	void contextLoads() {
	}

	@Test
	void testCreditCardPayment() {
		CreditCard cc = new CreditCard();
		cc.setAmount(1000);
		cc.setCardnumber("12345678");
		cc.setId(123);
		repository.save(cc);
	}

	@Test
	void testChequePayment() {
		Cheque ch = new Cheque();
		ch.setAmount(1000);
		ch.setChecknumber("12345678");
		ch.setId(124);
		repository.save(ch);
	}



}
