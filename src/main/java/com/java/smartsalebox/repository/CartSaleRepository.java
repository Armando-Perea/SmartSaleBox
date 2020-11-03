package com.java.smartsalebox.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.java.smartsalebox.models.CartSale;


@Repository
public interface CartSaleRepository extends CrudRepository<CartSale,Integer> {

	@Override
	<S extends CartSale> S save(S s);
	
	@Query("select cart from CartSale cart where cart.noSale= :noSale")
	public List<CartSale> findByNoSale(@Param("noSale") Integer noSale);
	
}
