package com.java.smartsalebox.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.java.smartsalebox.models.Sales;

public interface SalesRepository extends CrudRepository<Sales,Integer> {

	@Override
	<S extends Sales> S save(S s);
	
	@Query("select sales from Sales sales where sales.noSale= :noSale")
	public List<Sales> findByNoSale(@Param("noSale") Integer noSale);
	
}
