package com.java.smartsalebox.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.java.smartsalebox.models.Cash;

@Repository
public interface CashRepository extends CrudRepository<Cash,Integer> {

	@Override
	<S extends Cash> S save(S s);
	
}
