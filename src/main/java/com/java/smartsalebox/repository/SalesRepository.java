package com.java.smartsalebox.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.java.smartsalebox.models.Sales;

public interface SalesRepository extends CrudRepository<Sales,Integer> {

	@Override
	<S extends Sales> S save(S s);
	
	@Query("select sales from Sales sales where sales.idProduct= :idProduct and sales.type='GENERAL'")
	public Optional<Sales> findByIdProductGeneral(@Param("idProduct") Integer idProduct);
	
	@Query("select sales from Sales sales where sales.noSale= :noSale")
	public List<Sales> findByNoSale(@Param("noSale") Integer noSale);
	
	@Query("select sales from Sales sales where sales.idProduct= :idProduct and sales.noSale= :noSale and sales.type='GENERAL'")
	public Sales findByProductIdGeneralAndNoSale(@Param("idProduct") Integer idProduct,@Param("noSale") Integer noSale);
	
	@Transactional
	@Modifying
	@Query("delete from Sales sales where sales.noSale= :noSale")
	public Integer deleteSaleByNoSale(@Param("noSale") Integer noSale);
	
	@Modifying
	@Query(value = "truncate smartsalebox.sales", nativeQuery = true)
	public void truncateSales();
	
}
