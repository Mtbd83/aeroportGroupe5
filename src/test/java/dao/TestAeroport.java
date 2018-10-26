package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import dao.DaoAeroport;
import dao.DaoAeroportFactory;
import model.Aeroport;

public class TestAeroport {
	private static DaoAeroport daoAeroport;

	@BeforeClass
	public static void initDao() {
		daoAeroport = DaoAeroportFactory.getInstance();
	}

//	@Test
	public void testCreate() {
		Aeroport aeroport = new Aeroport();
		aeroport.setNom("charles_de_gaulle");
		daoAeroport.create(aeroport);
		assertNotNull(daoAeroport.findByKey(aeroport.getIdAeroport()));

		aeroport.setNom("orly");
		daoAeroport.update(aeroport);
		assertEquals("orly", daoAeroport.findByKey(aeroport.getIdAeroport()).getNom());
	}

//	@Test
	public void testDelete() {
		Aeroport aeroport = new Aeroport();
		aeroport.setNom("heathrow");
		daoAeroport.create(aeroport);

		daoAeroport.delete(daoAeroport.findByKey(aeroport.getIdAeroport()));
		assertNull(daoAeroport.findByKey(aeroport.getIdAeroport()));
	}

//	@Test
	public void testDeleteByKey() {
		Aeroport aeroport = new Aeroport();
		aeroport.setNom("gatwick");
		daoAeroport.create(aeroport);

		daoAeroport.deleteByKey(aeroport.getIdAeroport());
		assertNull(daoAeroport.findByKey(aeroport.getIdAeroport()));
	}

	@Test
	public void testFindAll() {
		Aeroport aeroport1 = new Aeroport();
		aeroport1.setNom("gatwick");
		daoAeroport.create(aeroport1);
		Aeroport aeroport2 = new Aeroport();
		aeroport2.setNom("orly");
		daoAeroport.create(aeroport2);
		Aeroport aeroport3 = new Aeroport();
		aeroport3.setNom("charles_de_gaulle");
		daoAeroport.create(aeroport3);

		List<Aeroport> aeroports = daoAeroport.findAll();
		System.out.println(aeroports);

	}

}
