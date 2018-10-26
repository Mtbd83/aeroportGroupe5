package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import dao.DaoVille;
import dao.DaoVilleFactory;
import model.Ville;

public class TestVille {
	private static DaoVille daoVille;

	@BeforeClass
	public static void initDao() {
		daoVille = DaoVilleFactory.getInstance();
	}

//	@Test
	public void testCreate() {
		Ville ville = new Ville();
		ville.setNom("paris");
		daoVille.create(ville);
		assertNotNull(daoVille.findByKey(ville.getIdVille()));

		ville.setNom("parislabelle");
		daoVille.update(ville);
		assertEquals("parislabelle", daoVille.findByKey(ville.getIdVille()).getNom());
	}

//	@Test
	public void testDelete() {
		Ville ville = new Ville();
		ville.setNom("diego");
		daoVille.create(ville);

		daoVille.delete(daoVille.findByKey(ville.getIdVille()));
		assertNull(daoVille.findByKey(ville.getIdVille()));
	}

//	@Test
	public void testDeleteByKey() {
		Ville ville = new Ville();
		ville.setNom("diego_suarez");
		daoVille.create(ville);

		daoVille.deleteByKey(ville.getIdVille());
		assertNull(daoVille.findByKey(ville.getIdVille()));
	}

	@Test
	public void testFindAll() {
		Ville ville = new Ville();
		ville.setNom("bruxelles");
		daoVille.create(ville);

		Ville ville2 = new Ville();
		ville2.setNom("lyon");
		daoVille.create(ville2);

		Ville ville3 = new Ville();
		ville3.setNom("marseille");
		daoVille.create(ville3);

		List<Ville> villes = daoVille.findAll();
		System.out.println(villes);
	}

}
