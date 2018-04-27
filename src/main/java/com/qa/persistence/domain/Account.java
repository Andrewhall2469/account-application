package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ACCOUNT")
public class Account {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(length =4, name ="ACCOUNT_NUMBER")
	private Long id;
	
	@Column(length = 50, name="FIRST_NAME")
	private String firstName;
	
	@Column(length = 50, name="LAST_NAME")
	private String lastName;
	
	public Account() 
	{}
	
	public Account(String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
	}

	
	public Long getId() {
		return id;
	}
	
	public Long accountNumber() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
