package com.java.smartsalebox.repo.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.java.smartsalebox.models.Outflow;
import com.java.smartsalebox.repository.OutflowRepository;

@Repository
public class OutflowRepoImpl {
	
	@Autowired
	OutflowRepository outflowRepository;
	
	public List<Outflow> getAllOutflow() {
		return (List<Outflow>) outflowRepository.findAll();
	}
	
	public Optional<Outflow> getOutflowById(Integer id) {
		return outflowRepository.findById(id);
	}
	
	public List<Outflow> getOutflowByConcept(String concept) {
		return outflowRepository.findByConcept(concept);
	}
	
	public List<Outflow> getOutflowByPaymentType(String paymentType) {
		return outflowRepository.findByPaymentType(paymentType);
	}
	
	public Outflow saveOutflow(Outflow outflow) {
		return outflowRepository.save(outflow);
	}
	
	public Outflow updateOutflow(Outflow outflow) {
		return outflowRepository.save(outflow);
	}
	
	public void deleteOutflow(Integer id) {
		outflowRepository.deleteById(id);
	}
	
	public void truncateOutflow() {
		outflowRepository.truncateOutflow();
	}

}