package com.qa.business.service;

public interface IAccountService {
	
	
	String getAllAccounts();
	String createAccounts(String account);
	String removeAccount(Long id);
	String editAccount (Long id, String newJSON);

}
