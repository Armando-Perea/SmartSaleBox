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
@Table(name="administrator", schema="smartsalebox")
@Entity
@ToString
public class Administrator {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idAdministrator")
	Integer idAdministrator;
	
	@Column(name="adminName")
	String adminName;
	
	@Column(name="adminLastName")
	String adminLastName;
	
	@Column(name="adminPhone")
	String adminPhone;
	
	@Column(name="adminPassword")
	String adminPassword;
	
	@Column(name="adminRole")
	String adminRole;
}
