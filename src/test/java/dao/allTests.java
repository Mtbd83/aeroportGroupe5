package dao;

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

public class allTests {

	private static EntityManagerFactory emf = null;
	private EntityManager em = null;
	private static DaoLogin daoLogin;
	private static DaoAeroport daoAeroport;
	private static DaoClient daoClient;
	private static DaoCompagnie daoCompagnie;
	private static DaoVol daoVol;
	private static DaoCompagnieVol daoCompagnieVol;
	private static DaoEscale daoEscale;
	private static DaoPassager daoPassager;
	private static DaoReservation daoReservation;
	private static DaoVille daoVille;
	private static DaoVilleAeroport daoVilleAeroport;
	private static DaoVol daoVol;

	@BeforeClass
	public static void initEntityManagerFactory() {
		emf = Persistence.createEntityManagerFactory("les5Fantastiques");
		daoLogin = DaoLoginFactory.getInstance();
		daoAeroport=DaoAeroportFactory.getInstance();
		daoClient=DaoClientFactory.getInstance();
		daoCompagnie=DaoClientFactory.getInstance();
		daoVol=DaoVolFactory.getInstance();
		daoCompagnieVol=DaoCompagnieVolFactory.getInstance();
		daoEscale=DaoEscaleFactory.getInstance();
		daoPassager=DaoPassagerFactory.getInstance();
		daoReservation=DaoReservationFactory.getInstance();
		daoVille=DaoVilleFactory.getInstance();
		daoVilleAeroport=DaoVilleAeroportFactory.getInstance();
		daoVol=DaoVolFactory.getInstance();
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
