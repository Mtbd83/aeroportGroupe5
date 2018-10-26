package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import dao.DaoCompagnie;
import dao.DaoCompagnieFactory;
import model.Compagnie;

public class TestCompagnie {
	private static DaoCompagnie daoCompagnie;

	@BeforeClass
	public static void initDao() {
		daoCompagnie = DaoCompagnieFactory.getInstance();
	}

//	@Test
	public void testCreate() {
		Compagnie compagnie = new Compagnie();
		compagnie.setNom("air_france");
		daoCompagnie.create(compagnie);
		assertNotNull(daoCompagnie.findByKey(compagnie.getIdCompagnie()));

		compagnie.setNom("ryan_air");
		daoCompagnie.update(compagnie);
		assertEquals("ryan_air", daoCompagnie.findByKey(compagnie.getIdCompagnie()).getNom());
	}

//	@Test
	public void testDelete() {
		Compagnie compagnie = new Compagnie();
		compagnie.setNom("air_madagascar");
		daoCompagnie.create(compagnie);

		daoCompagnie.delete(daoCompagnie.findByKey(compagnie.getIdCompagnie()));
		assertNull(daoCompagnie.findByKey(compagnie.getIdCompagnie()));
	}

//	@Test
	public void testDeleteByKey() {
		Compagnie compagnie = new Compagnie();
		compagnie.setNom("air_espagne");
		daoCompagnie.create(compagnie);

		daoCompagnie.deleteByKey(compagnie.getIdCompagnie());
		assertNull(daoCompagnie.findByKey(compagnie.getIdCompagnie()));
	}

	@Test
	public void testFindAll() {
		Compagnie compagnie1 = new Compagnie();
		compagnie1.setNom("air_france");
		daoCompagnie.create(compagnie1);

		compagnie1 = new Compagnie();
		compagnie1.setNom("air_espagne");
		daoCompagnie.create(compagnie1);

		compagnie1 = new Compagnie();
		compagnie1.setNom("ryan_air");
		daoCompagnie.create(compagnie1);

		List<Compagnie> compagnies = daoCompagnie.findAll();
		System.out.println(compagnies);
	}

}
