package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Login;
import util.Context;

public class DaoLoginTest {
	private static DaoLogin daoLogin;


	@BeforeClass
	public static void initEntityManagerFactory() {
		daoLogin = DaoLoginFactory.getInstance();
	}

	@AfterClass
	public static void closeEntityManagerFactory() {
		 Context.destroy();
	}


	@Test
	public void createTestLogin() {
		Login login=new Login("user","motDePasse");
		assertNull(login.getId());
		daoLogin.create(login);
		login=daoLogin.findByKey(login.getId());
		assertNotNull(login.getId());
	}
	@Test
	public void findByKey() {
		Login l = new Login("user2","motDePasse");
		daoLogin.create(l);
		assertNotNull(daoLogin.findByKey(l.getId()));
	}
	
	@Test
	public void update() {
		Login l = new Login("update", "update");
		daoLogin.create(l);
		l = daoLogin.findByKey(l.getId());
		l.setLogin("admin");
		daoLogin.update(l);
		assertEquals("admin", daoLogin.findByKey(l.getId()).getLogin());
	}
	
	@Test
	public void delete() {
		Login login = new Login("delete", "delete");
		daoLogin.create(login);
		daoLogin.delete(login);
		assertNull(daoLogin.findByKey(login.getId()));
	}

	@Test
	public void deleteByKey() {
		Login login = new Login("delete", "delete");
		daoLogin.create(login);
		daoLogin.deleteByKey(login.getId());
		assertNull(daoLogin.findByKey(login.getId()));
	}

}