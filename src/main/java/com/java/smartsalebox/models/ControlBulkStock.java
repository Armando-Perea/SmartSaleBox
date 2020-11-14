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
@Table(name="ControlBulkStock", schema="smartsalebox")
@Entity
@ToString
public class ControlBulkStock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idControlBulkStock")
	Integer idControlBulkStock;
	
	@Column(name="idBulkProduct")
	Integer idBulkProduct;
	
	@Column(name="grStock")
	Double grStock;	
	
}
