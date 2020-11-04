package com.java.smartsalebox.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.java.smartsalebox.models.Outflow;

@Repository
public interface OutflowRepository extends CrudRepository<Outflow,Integer> {

	@Override
	<S extends Outflow> S save(S s);
	
	@Query("select outflow from Outflow outflow where outflow.concept=:concept")
	public List<Outflow> findByConcept(@Param("concept") String concept);
	
	@Query("select outflow from Outflow outflow where outflow.paymentType=:paymentType")
	public List<Outflow> findByPaymentType(@Param("paymentType") String paymentType);
	
	@Modifying
	@Query(value = "truncate smartsalebox.outflow", nativeQuery = true)
	public void truncateOutflow();
}
