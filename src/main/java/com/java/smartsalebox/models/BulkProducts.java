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
@Table(name="bulkProducts", schema="smartsalebox")
@Entity
@ToString
public class BulkProducts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idBulkProduct")
	Integer idBulkProduct;
	
	@Column(name="product")
	String product;
	
	@Column(name="type")
	String type;
	
	@Column(name="costPrice")
	Double costPrice;
	
	@Column(name="kiloPrice")
	Double kiloPrice;
	
	@Column(name="grStock")
	Double grStock;
	
	@Column(name="kiloEarning")
	Double kiloEarning;
	
	@Column(name="bulkEarning")
	Double earning;
	
	@Column(name="barCode")
	String barCode;
	
}
