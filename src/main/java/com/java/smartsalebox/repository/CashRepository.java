package com.java.smartsalebox.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.java.smartsalebox.models.Cash;

@Repository
public interface CashRepository extends CrudRepository<Cash, Integer> {

	@Override
	<S extends Cash> S save(S s);

	@Modifying
	@Query(value = "truncate smartsalebox.cash", nativeQuery = true)
	public void truncateCash();
}
