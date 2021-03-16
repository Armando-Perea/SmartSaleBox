package com.java.smartsalebox.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.java.smartsalebox.models.Administrator;

@Repository
public interface AdminRepository extends CrudRepository<Administrator,Integer> {


	@Override
	<S extends Administrator> S save(S s);
	
	@Query("select admin from Administrator admin where admin.adminName like %:adminName%")
	public List<Administrator> findByName(@Param("adminName") String adminName);
	
	@Query("select admin from Administrator admin where admin.adminName=:adminName and admin.adminPassword=:adminPassword")
	public List<Administrator> getAdminByNameAndPassword(@Param("adminName") String adminName,@Param("adminPassword") String adminPassword);
	
	@Modifying
	@Query(value = "truncate smartsalebox.administrator", nativeQuery = true)
	public void truncateAdmin();
}
