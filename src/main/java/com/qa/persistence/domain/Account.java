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
	private Long accountNumber;
	
	@Column(length = 50, name="FIRST_NAME")
	private String firstName;
	
	@Column(length = 50, name="LAST_NAME")
	private String lastName;
	
	@Column(length = 4, name = "altAccountNumber")
	private int altAccountNumber;
	
	public Account() 
	{}
	
	public Account(String firstName, String lastName, int altAccountNumber)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.altAccountNumber = altAccountNumber;
	}

	public Long accountNumber() {
		return accountNumber;
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

	public int getAltAccNumber() {
		return altAccountNumber;
	}

	public void setAltAccNumber(int altAccountNumber) {
		this.altAccountNumber = altAccountNumber;
	}
}
