package com.java.smartsalebox.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.smartsalebox.models.ControlProductStock;
import com.java.smartsalebox.repo.impl.ControlProductStockRepoImpl;

import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@RequestMapping("smartsalebox/system/controlProductStock")
public class ControlProductStockController {

	@Autowired
	ControlProductStockRepoImpl controlProductStockRepoImpl;
	
	@GetMapping("/getAllControlProductStock")
	public List<ControlProductStock> getAllProducts(){
		log.info("getAllControlProductStock Controller");
	 return controlProductStockRepoImpl.getAllControlProductStock();
	}
	
	@GetMapping("/getControlProductStockById/{id}")
	public Optional<ControlProductStock> getControlProductStockById(@PathVariable Integer id){
		log.info("getControlProductStockById Controller");
	 return controlProductStockRepoImpl.getControlProductStockById(id);
	}
	
	@GetMapping("/getControlProductStockByIdProduct/{idProduct}")
	public List<ControlProductStock> getProductByIdProduct(@PathVariable Integer idProduct){
		log.info("getControlProductStockByIdProduct Controller");
	 return controlProductStockRepoImpl.getControlProductStockByIdProduct(idProduct);
	}
	
	@PostMapping("/createControlProductStock")
	public ControlProductStock createControlProductStock(@RequestBody ControlProductStock controlProductStock){
		log.info("createControlProductStock Controller");
	 return controlProductStockRepoImpl.saveControlProductStock(controlProductStock);
	}
	
	@PutMapping("/updateControlProductStock")
	public ControlProductStock updateControlProductStock(@RequestBody ControlProductStock controlProductStock){
		log.info("updateControlProductStock Controller");
		return controlProductStockRepoImpl.saveControlProductStock(controlProductStock);
	}
	
	@DeleteMapping("/deleteControlProductStock/{id}")
	public void deleteControlProductStock(@PathVariable Integer id){
		log.info("deleteControlProductStock Controller");
		controlProductStockRepoImpl.deleteControlProductStock(id);
	}
	
	@Transactional
	@GetMapping("/truncateControlProductStock")
	public String truncateControlProductStock(){
		log.info("truncateControlProductStock Controller");
		controlProductStockRepoImpl.truncateControlProductStock();
		return "Truncated";
	}
	
}
