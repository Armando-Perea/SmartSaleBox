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
@Table(name="systempaths", schema="smartsalebox")
@Entity
@ToString
public class SystemPaths {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idPath")
	Integer idPath;
	
	@Column(name="inflowsPdf")
	String inflowsPdf;
	
	@Column(name="outflowsPdf")
	String outflowsPdf;
	
	@Column(name="salesPdf")
	String salesPdf;
	
	@Column(name="closurePdf")
	String closurePdf;
	
	@Column(name="productEarningsPdf")
	String productEarningsPdf;
	
	@Column(name="productsPdf")
	String productsPdf;
	
}
