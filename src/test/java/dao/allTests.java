package les5Fantastiques;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.DaoAdresse;
import dao.DaoAdresseFactory;
import dao.DaoLogin;
import dao.DaoLoginFactory;
import util.Context;

public class volTest {

	private static EntityManagerFactory emf = null;
	private EntityManager em = null;
	private static DaoLogin daoLogin;
	private static DaoAdresse daoAdresse;

	@BeforeClass
	public static void initEntityManagerFactory() {
		emf = Persistence.createEntityManagerFactory("les5Fantastiques");
		daoLogin = DaoLoginFactory.getInstance();
		daoAdresse = DaoAdresseFactory.getInstance();
	}

	@AfterClass
	public static void closeEntityManagerFactory() {
		emf.close();
		 Context.destroy();
	}

	@Before
	public void initEntityManager() {
		em = emf.createEntityManager();
	}

	@After
	public void closeEntityManager() {
		em.close();
	}

	@Test
	public void test() {
		assertNotNull(emf);
		assertNotNull(em);

	}

}
