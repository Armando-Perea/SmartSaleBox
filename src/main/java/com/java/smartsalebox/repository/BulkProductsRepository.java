package com.java.smartsalebox.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.java.smartsalebox.models.BulkProducts;

@Repository
public interface BulkProductsRepository extends CrudRepository<BulkProducts,Integer> {

	@Override
	<S extends BulkProducts> S save(S s);
	
	@Query("select prod from BulkProducts prod where prod.product like %:product%")
	public List<BulkProducts> findByName(@Param("product") String name);
	
	@Modifying
	@Query(value = "truncate smartsalebox.bulk_products", nativeQuery = true)
	public void truncateBulkProducts();
	
}
