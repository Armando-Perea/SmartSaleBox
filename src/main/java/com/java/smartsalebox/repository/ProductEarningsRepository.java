package com.java.smartsalebox.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.java.smartsalebox.models.ProductEarnings;

@Repository
public interface ProductEarningsRepository extends CrudRepository<ProductEarnings,Integer> {

	@Override
	<S extends ProductEarnings> S save(S s);
	
	@Query("select prod from ProductEarnings prod where prod.idProduct = :idProduct")
	public Optional<ProductEarnings> findByProductId(@Param("idProduct") Integer idProduct);
	
	@Query("select prod from ProductEarnings prod where prod.productName like %:productName%")
	public List<ProductEarnings> findByName(@Param("productName") String productName);
	
	@Modifying
	@Query(value = "truncate smartsalebox.products_earnings",nativeQuery = true)
	public  void truncateProductEarnings();
	
}
