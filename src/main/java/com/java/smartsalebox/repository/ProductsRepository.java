package com.java.smartsalebox.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.java.smartsalebox.models.Products;

@Repository
public interface ProductsRepository extends CrudRepository<Products,Integer> {

	@Override
	<S extends Products> S save(S s);
	
	@Query("select prod from Products prod where prod.product like %:product%")
	public List<Products> findByName(@Param("product") String name);
	
	@Modifying
	@Query(value = "truncate smartsalebox.products", nativeQuery = true)
	public void truncateProducts();
}
