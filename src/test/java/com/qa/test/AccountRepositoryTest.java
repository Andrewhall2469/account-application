import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.business.repository.AccountDBRepository;
import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class AccountRepositoryTest {
	
	@InjectMocks
	private AccountDBRepository repo;
	
	@Mock
	private EntityManager em;
	
	@Mock
	private Query query;
	
	private JSONUtil jSON;
	
	@Before
	public void setup()
	{
		repo.manager(em);
		jSON = new JSONUtil();
		repo.setUtil(jSON);
	}

	@Test
	public void getAllAccountsTest() 
	{
		Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(query);
		List<Account> testAccounts = new ArrayList<Account>();
		testAccounts.add(new Account("Peter", "Pan", 1001));
		Mockito.when(query.getResultList()).thenReturn(testAccounts);
		String expected = "[{\"firstName\":\"Peter\",\"lastName\":\"Pan\",\"altAccountNumber\":1001}]";
		String actual = repo.getAllAccounts();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void createAccountTest()
	{
		String expected = repo.createAccount("{\"firstName\":\"Peter\",\"secondName\":\"Pan\",\"altAccountNumber\":1001}");
		String actual = "Account added";
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void EditAccountTest()
	{
		String expected = repo.editAccount(1001, "{\"firstName\":\"Peter\",\"secondName\":\"NotPan\"}");
		String actual = "Account Updated";
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void removeAccountTest()
	{
		String actual = repo.removeAccount(1001);
		String expected = "Account Removed From Database";
		Assert.assertEquals(actual, expected);
	}

}
