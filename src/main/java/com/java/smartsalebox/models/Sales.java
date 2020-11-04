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
@Table(name="sales", schema="smartsalebox")
@Entity
@ToString
public class Sales {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idSale")
	Integer idSale;
	
	@Column(name="noSale")
	Integer noSale;
	
	@Column(name="description")
	String description;
	
	@Column(name="units")
	Integer units;
	
	@Column(name="paymentType")
	String paymentType;
	
	@Column(name="cardFare")
	Double cardFare;
	
	@Column(name="total")
	Double total;
	
	@Column(name="saleDate")
	Date saleDate;
	
}
