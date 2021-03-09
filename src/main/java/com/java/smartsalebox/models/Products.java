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
@Table(name="products", schema="smartsalebox")
@Entity
@ToString
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idProduct")
	Integer idProduct;
	
	@Column(name="product")
	String product;
	
	@Column(name="type")
	String type;
	
	@Column(name="costPrice")
	Double costPrice;
	
	@Column(name="salePrice")
	Double salePrice;
	
	@Column(name="earning")
	Double earning;
	
	@Column(name="stock")
	Integer stock;
	
	@Column(name="barCode")
	String barCode;
	
}
