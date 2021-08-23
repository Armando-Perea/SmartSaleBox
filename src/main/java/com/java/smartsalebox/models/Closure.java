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
@Table(name="closure", schema="smartsalebox")
@Entity
@ToString
public class Closure {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idClosure")
	Integer idClosure;
	
	@Column(name="attendee")
	String attendee;
	
	@Column(name="initCash")
	Double initCash;
	
	@Column(name="closureCash")
	Double closureCash;
	
	@Column(name="products")
	Double products;
	
	@Column(name="cardPayments")
	Double cardPayments;
	
	@Column(name="cashPayments")
	Double cashPayments;
	
	@Column(name="totalInflow")
	Double totalInflow;
	
	@Column(name="totalOutflow")
	Double totalOutflow;
	
	@Column(name="earning")
	Double earning;
	
	@Column(name="closureDate")
	String closureDate;

}
