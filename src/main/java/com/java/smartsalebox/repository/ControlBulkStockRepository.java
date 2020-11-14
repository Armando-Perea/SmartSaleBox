package com.java.smartsalebox.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.java.smartsalebox.models.ControlBulkStock;


public interface ControlBulkStockRepository extends CrudRepository<ControlBulkStock,Integer> {

	@Override
	<S extends ControlBulkStock> S save(S s);
	
	@Query("select prod from ControlBulkStock prod where prod.idBulkProduct= :idBulkProduct")
	public List<ControlBulkStock> findByIdBulkProduct(@Param("idBulkProduct") Integer idBulkProduct);
	
	@Modifying
	@Query(value = "truncate smartsalebox.control_bulk_stock", nativeQuery = true)
	public void truncateControlBulkStock();
}
