package com.qa.business.service;

import javax.inject.Inject;

import com.qa.business.repository.IAccountRepository;

public class AccountService implements IAccountService {

	@Inject
	private IAccountRepository repo;
	
	@Override
	public String getAllAccounts() {
		
		return repo.getAllAccounts();
	}

	@Override 
	public String createAccounts(String account) {
		
		return repo.createAccount(account);
	}

	@Override
	public String removeAccount(Long id) {
		
		return repo.removeAccount(id);
	}

	@Override
	public String editAccount(Long id, String newJSON) {
		
		return repo.editAccount(id, newJSON);
	}

}
