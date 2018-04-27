package com.qa.business.repository;

public interface IAccountRepository {

	String getAllAccounts();
	
	String createAccount(String Account);
	
	String editAccount(Long id, String update);
	
	String removeAccount(Long id);

}