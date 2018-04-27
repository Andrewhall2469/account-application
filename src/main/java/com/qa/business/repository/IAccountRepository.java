package com.qa.business.repository;

public interface IAccountRepository {

	String getAllAccounts();
	
	String createAccount(String Account);
	
	String editAccount(int altAccountNumber, String update);
	
	String removeAccount(int altAccountNumber);

}