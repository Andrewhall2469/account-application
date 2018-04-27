package com.qa.business.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;


import org.apache.log4j.Logger;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class AccountDBRepository implements IAccountRepository {
	
	private static final Logger LOGGER = Logger.getLogger(AccountDBRepository.class);
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Inject
	private JSONUtil jSON;
	
	
	@Override
	public String getAllAccounts() 
	{
		LOGGER.info("AccountDBRepository getAllAccounts");
		Query query = em.createQuery("SELECT a FROM Account a");
		Collection<Account> accounts = (Collection<Account>) query.getResultList();
		return jSON.getJSONForObject(accounts);
	}
	
	@Override
	@Transactional(REQUIRED)
	public String createAccount(String account)
	{
		Account newAccount = jSON.getObjectforJSON(account, Account.class);
		em.persist(newAccount);
		return "{\"message\":\"account added\"}";
		
	}
	
	@Override
	@Transactional(REQUIRED)
	public String editAccount(Long id, String update) {
		Account updateAccount = jSON.getObjectforJSON(update, Account.class);
		Account findAcc = findAccount(id);
		if (update != null)
		{
			findAcc = updateAccount;
			em.merge(findAcc);
		}
		return "{\"message\":\"account updated\"}";
	}
	
	@Override
	@Transactional(REQUIRED)
	public String removeAccount(Long id) {
		Account deleteAccount = findAccount(id);
		if (deleteAccount != null)
		{
			em.remove(deleteAccount);
		}
		return "{\"message\":\"account removed\"}";
		
	}
	
	public Account findAccount(Long id) 
	{
		return em.find(Account.class, id);
	}
	
	public void manager(EntityManager em) 
	{
		this.em = em;
	}
	
	public void setUtil(JSONUtil jSON) 
	{
		this.jSON = jSON;
	}

}
