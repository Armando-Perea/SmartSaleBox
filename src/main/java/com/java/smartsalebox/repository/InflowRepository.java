package com.java.smartsalebox.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.java.smartsalebox.models.Inflow;

@Repository
public interface InflowRepository extends CrudRepository<Inflow,Integer>{

	@Override
	<S extends Inflow> S save(S s);
	
	@Query("select inflow from Inflow inflow where inflow.concept=:concept")
	public List<Inflow> findByConcept(@Param("concept") String concept);
	
	@Query("select inflow from Inflow inflow where inflow.paymentType=:paymentType")
	public List<Inflow> findByPaymentType(@Param("paymentType") String paymentType);
	
	@Modifying
	@Query(value = "truncate smartsalebox.inflow", nativeQuery = true)
	public void truncateInflow();
}
