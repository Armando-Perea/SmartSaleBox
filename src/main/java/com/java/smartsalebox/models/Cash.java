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
@Table(name="cash", schema="smartsalebox")
@Entity
@ToString
public class Cash {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idCash")
	Integer idCash;
	
	@Column(name="quantity")
	Double quantity;
	
	@Column(name="noSale")
	Integer noSale;	
	
	@Column(name="ticketTitle")
	String ticketTitle;	
	
}
