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
@Table(name="employee", schema="smartsalebox")
@Entity
@ToString
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idEmployee")
	Integer idEmployee;
	
	@Column(name="employeeName")
	String employeeName;
	
	@Column(name="employeeLastName")
	String employeeLastName;
	
	@Column(name="employeePhone")
	String employeePhone;
	
	@Column(name="employeePassword")
	String employeePassword;
	
	@Column(name="employeeRole")
	String employeeRole;
}
