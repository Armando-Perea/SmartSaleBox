package com.java.smartsalebox.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.java.smartsalebox.models.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Integer> {


	@Override
	<S extends Employee> S save(S s);
	
	@Query("select employee from Employee employee where employee.employeeName like %:name%")
	public List<Employee> findByName(@Param("name") String name);
	
}
