package com.java.smartsalebox.repo.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.java.smartsalebox.models.CartSale;
import com.java.smartsalebox.repository.CartSaleRepository;

@Repository
public class CartSaleRepoImpl {
	
	@Autowired
	CartSaleRepository cartSaleRepository;
	
	public List<CartSale> getAllCartSale() {
		return (List<CartSale>) cartSaleRepository.findAll();
	}
	
	public Optional<CartSale> getCartSaleById(Integer id) {
		return cartSaleRepository.findById(id);
	}
	
	public List<CartSale> getCartSaleByNoSale(Integer noSale) {
		return cartSaleRepository.findByNoSale(noSale);
	}
	
	public CartSale saveCartSale(CartSale cart) {
		return cartSaleRepository.save(cart);
	}
	
	public CartSale updateCartSale(CartSale cat) {
		return cartSaleRepository.save(cat);
	}
	
	public void deleteCartSale(Integer id) {
		cartSaleRepository.deleteById(id);
	}
	
	public void truncateCartSale() {
		cartSaleRepository.truncateCartSale();
	}

}
