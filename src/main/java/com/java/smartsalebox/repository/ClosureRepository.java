package com.java.smartsalebox.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.java.smartsalebox.models.Closure;

@Repository
public interface ClosureRepository extends CrudRepository<Closure,Integer> {

	@Override
	<S extends Closure> S save(S s);
	
}
