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
@Table(name="inflow", schema="smartsalebox")
@Entity
@ToString
public class Inflow {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idInflow")
	Integer idInflow;
	
	@Column(name="concept")
	String concept;
	
	@Column(name="description")
	String description;
	
	@Column(name="quantity")
	Double quantity;
	
	@Column(name="paymentType")
	String paymentType;
	
	@Column(name="attendee")
	String attendee;
	
	@Column(name="inflowDate")
	String inflowDate;
	
}
