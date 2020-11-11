package com.java.smartsalebox.repo.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.smartsalebox.models.CashPayment;
import com.java.smartsalebox.repository.CashPaymentRepository;


@Repository
public class CashPaymentRepoImpl {

	@Autowired
	CashPaymentRepository cashPaymentRepository;
	
	public List<CashPayment> getAllCashPayment() {
		return (List<CashPayment>) cashPaymentRepository.findAll();
	}
	
	public Optional<CashPayment> getCashPaymentById(Integer id) {
		return cashPaymentRepository.findById(id);
	}
	
	public CashPayment saveCashPayment(CashPayment cashPayment) {
		return cashPaymentRepository.save(cashPayment);
	}
	
	public CashPayment updateCashPayment(CashPayment cashPayment) {
		return cashPaymentRepository.save(cashPayment);
	}
	
	public void deleteCashPayment(Integer id) {
		cashPaymentRepository.deleteById(id);
	}
	
	public void truncateCashPayment() {
		cashPaymentRepository.truncateCashPayment();
	}
}
