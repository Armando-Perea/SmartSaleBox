package com.java.smartsalebox.repo.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.java.smartsalebox.models.Closure;
import com.java.smartsalebox.repository.ClosureRepository;

@Repository
public class ClosureRepoImpl {
	
	@Autowired
	ClosureRepository closureRepository;
	
	public List<Closure> getAllClosure() {
		return (List<Closure>) closureRepository.findAll();
	}
	
	public Optional<Closure> getClosureById(Integer id) {
		return closureRepository.findById(id);
	}
	
	public Closure saveClosure(Closure closure) {
		return closureRepository.save(closure);
	}
	
	public Closure updateClosure(Closure closure) {
		return closureRepository.save(closure);
	}
	
	public void deleteClosure(Integer id) {
		closureRepository.deleteById(id);
	}
	
	public void truncateClosure() {
		closureRepository.truncateClosure();
	}

}
