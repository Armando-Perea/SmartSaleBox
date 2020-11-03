package com.java.smartsalebox.repo.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.java.smartsalebox.models.Cash;
import com.java.smartsalebox.repository.CashRepository;

@Repository
public class CashRepoImpl {
	
	@Autowired
	CashRepository cashRepository;
	
	public Optional<Cash> getCashById(Integer id) {
		return cashRepository.findById(id);
	}
	
	public Cash saveCash(Cash cash) {
		return cashRepository.save(cash);
	}
	
	public Cash updateCash(Cash cash) {
		return cashRepository.save(cash);
	}
	
	public void deleteCash(Integer id) {
		cashRepository.deleteById(id);
	}

}
