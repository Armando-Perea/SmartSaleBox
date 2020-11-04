package com.java.smartsalebox.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.java.smartsalebox.models.Closure;

@Repository
public interface ClosureRepository extends CrudRepository<Closure,Integer> {

	@Override
	<S extends Closure> S save(S s);
	
	@Modifying
	@Query(value = "truncate smartsalebox.closure", nativeQuery = true)
	public void truncateClosure();
}
