package com.java.smartsalebox.repo.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.java.smartsalebox.models.Inflow;
import com.java.smartsalebox.repository.InflowRepository;

@Repository
public class InflowRepoImpl {
	
	@Autowired
	InflowRepository inflowRepository;
	
	public List<Inflow> getAllInflow() {
		return (List<Inflow>) inflowRepository.findAll();
	}
	
	public Optional<Inflow> getInflowById(Integer id) {
		return inflowRepository.findById(id);
	}
	
	public List<Inflow> getInflowByConcept(String concept) {
		return inflowRepository.findByConcept(concept);
	}
	
	public List<Inflow> getInflowByPaymentType(String paymentType) {
		return inflowRepository.findByPaymentType(paymentType);
	}
	
	public Inflow saveInflow(Inflow inflow) {
		return inflowRepository.save(inflow);
	}
	
	public Inflow updateInflow(Inflow inflow) {
		return inflowRepository.save(inflow);
	}
	
	public void deleteInflow(Integer id) {
		inflowRepository.deleteById(id);
	}
	
	public void truncateInflow() {
		inflowRepository.truncateInflow();
	}

}
