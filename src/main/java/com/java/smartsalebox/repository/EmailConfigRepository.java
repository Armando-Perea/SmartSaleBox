package com.java.smartsalebox.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.java.smartsalebox.models.EmailConfig;

@Repository
public interface EmailConfigRepository extends CrudRepository<EmailConfig,Integer>{

	@Override
	<S extends EmailConfig> S save(S s);
	
	@Modifying
	@Query(value = "truncate smartsalebox.email_config", nativeQuery = true)
	public void truncateEmailConfig();
}
