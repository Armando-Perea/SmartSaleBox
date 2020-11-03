package com.java.smartsalebox.models;

import java.sql.Date;

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
@Table(name="productsEarnings", schema="smartsalebox")
@Entity
@ToString
public class ProductEarnings {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idProductEarning")
	Integer idProductEarning;
	
	@Column(name="idProduct")
	Integer idProduct;
	
	@Column(name="productName")
	String productName;
	
	@Column(name="soldQuantity")
	Integer soldQuantity;
	
	@Column(name="unitEarning")
	Double unitEarning;
	
	@Column(name="totalEarning")
	Double totalEarning;
	
	@Column(name="saleDate")
	Date saleDate;

}
