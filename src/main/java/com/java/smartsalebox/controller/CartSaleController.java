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

import com.java.smartsalebox.models.CartSale;
import com.java.smartsalebox.repo.impl.CartSaleRepoImpl;

import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@RequestMapping("smartsalebox/system/cartSale")
public class CartSaleController {

	@Autowired
	CartSaleRepoImpl cartSaleRepoImpl;
	
	@GetMapping("/getAllCartSale")
	public List<CartSale> getAllCartSale(){
		log.info("getAllCartSale Controller");
	 return cartSaleRepoImpl.getAllCartSale();
	}
	
	@GetMapping("/getCartSaleById/{id}")
	public Optional<CartSale> getCartSaleById(@PathVariable Integer id){
		log.info("getCartSaleById Controller");
	 return cartSaleRepoImpl.getCartSaleById(id);
	}
	
	@GetMapping("/getCartSaleByNoSale/{noSale}")
	public List<CartSale> getCategoryByName(@PathVariable Integer noSale){
		log.info("getCartSaleByNoSale Controller");
	 return cartSaleRepoImpl.getCartSaleByNoSale(noSale);
	}
	
	@PostMapping("/createCartSale")
	public CartSale createCartSale(@RequestBody CartSale cart){
		log.info("createCartSale Controller");
	 return cartSaleRepoImpl.saveCartSale(cart);
	}
	
	@PutMapping("/updateCartSale")
	public CartSale updateCartSale(@RequestBody CartSale cart){
		log.info("updateCartSale Controller");
	 return cartSaleRepoImpl.saveCartSale(cart);
	}
	
	@DeleteMapping("/deleteCartSale/{id}")
	public void deleteCartSale(@PathVariable Integer id){
		log.info("deleteCartSale Controller");
		cartSaleRepoImpl.deleteCartSale(id);
	}
	
	@Transactional
	@GetMapping("/truncateCartSale")
	public String truncateCartSale(){
		log.info("truncateCartSale Controller");
		cartSaleRepoImpl.truncateCartSale();
		return "Truncated";
	}
	
}

