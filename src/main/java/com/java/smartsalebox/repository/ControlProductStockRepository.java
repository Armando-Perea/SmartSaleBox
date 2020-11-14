package com.java.smartsalebox.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.java.smartsalebox.models.ControlProductStock;

@Repository
public interface ControlProductStockRepository extends CrudRepository<ControlProductStock,Integer> {

	@Override
	<S extends ControlProductStock> S save(S s);
	
	@Query("select prod from ControlProductStock prod where prod.idProduct= :idProduct")
	public List<ControlProductStock> findByIdProduct(@Param("idProduct") Integer idProduct);
	
	@Modifying
	@Query(value = "truncate smartsalebox.control_product_stock", nativeQuery = true)
	public void truncateControlProductStock();
	
}
