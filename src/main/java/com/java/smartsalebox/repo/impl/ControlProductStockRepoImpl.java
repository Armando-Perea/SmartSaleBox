package com.java.smartsalebox.repo.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.smartsalebox.models.ControlProductStock;
import com.java.smartsalebox.repository.ControlProductStockRepository;


@Repository
public class ControlProductStockRepoImpl {

	@Autowired
	ControlProductStockRepository controlProductStockRepository;
	
	public List<ControlProductStock> getAllControlProductStock() {
		return (List<ControlProductStock>) controlProductStockRepository.findAll();
	}
	
	public Optional<ControlProductStock> getControlProductStockById(Integer id) {
		return controlProductStockRepository.findById(id);
	}
	
	public List<ControlProductStock> getControlProductStockByIdProduct(Integer id) {
		return controlProductStockRepository.findByIdProduct(id);
	}
	
	public ControlProductStock saveControlProductStock(ControlProductStock controlProductStock) {
		return controlProductStockRepository.save(controlProductStock);
	}
	
	public ControlProductStock updateControlProductStock(ControlProductStock controlProductStock) {
		return controlProductStockRepository.save(controlProductStock);
	}
	
	public void deleteControlProductStock(Integer id) {
		controlProductStockRepository.deleteById(id);
	}

	public void truncateControlProductStock() {
		controlProductStockRepository.truncateControlProductStock();
	}
}
