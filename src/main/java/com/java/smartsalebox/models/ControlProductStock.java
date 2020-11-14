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
@Table(name="controlProductStock", schema="smartsalebox")
@Entity
@ToString
public class ControlProductStock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idControlProductStock")
	Integer idControlProductStock;
	
	@Column(name="idProduct")
	Integer idProduct;
	
	@Column(name="stock")
	Integer stock;	
	
}
