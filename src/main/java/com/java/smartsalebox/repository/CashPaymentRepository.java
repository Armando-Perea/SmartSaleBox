package com.java.smartsalebox.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.java.smartsalebox.models.CashPayment;

@Repository
public interface CashPaymentRepository extends CrudRepository<CashPayment,Integer> {

	@Override
	<S extends CashPayment> S save(S s);
	
	 @Modifying
	 @Query(value = "truncate smartsalebox.cash_payment",nativeQuery = true)
	 public  void truncateCashPayment();
}
