package com.java.smartsalebox.repo.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.java.smartsalebox.models.ControlBulkStock;
import com.java.smartsalebox.repository.ControlBulkStockRepository;

public class ControlBulkStockRepoImpl {


	@Autowired
	ControlBulkStockRepository controlProductStockRepository;
	
	public List<ControlBulkStock> getAllControlBulkStock() {
		return (List<ControlBulkStock>) controlProductStockRepository.findAll();
	}
	
	public Optional<ControlBulkStock> getControlBulkStockById(Integer id) {
		return controlProductStockRepository.findById(id);
	}
	
	public List<ControlBulkStock> getControlBulkStockByIdProduct(Integer idBulkProduct) {
		return controlProductStockRepository.findByIdBulkProduct(idBulkProduct);
	}
	
	public ControlBulkStock saveControlBulkStock(ControlBulkStock controlBulkStock) {
		return controlProductStockRepository.save(controlBulkStock);
	}
	
	public ControlBulkStock updateControlBulkStock(ControlBulkStock controlBulkStock) {
		return controlProductStockRepository.save(controlBulkStock);
	}
	
	public void deleteControlBulkStock(Integer id) {
		controlProductStockRepository.deleteById(id);
	}

	public void truncateControlBulkStock() {
		controlProductStockRepository.truncateControlBulkStock();
	}
	
}
