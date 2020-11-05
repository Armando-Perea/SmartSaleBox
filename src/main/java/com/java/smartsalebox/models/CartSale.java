package com.java.smartsalebox.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@Table(name="cartSale", schema="smartsalebox")
@Entity
@ToString
public class CartSale {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idCartSale")
	Integer idCartSale;
	
	@Column(name="noSale")
	Integer noSale;
	
	@Column(name="idProduct")
	Integer  idProduct;
	
	@Column(name="description")
	String description;
	
	@Column(name="price")
	Double price;
	
	@Column(name="units")
	Integer  units;
	
	@Column(name="total")
	Double total;

}

