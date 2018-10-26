package dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import dao.DaoCompagnie;
import dao.DaoCompagnieFactory;
import dao.DaoCompagnieVol;
import dao.DaoCompagnieVolFactory;
import dao.DaoVol;
import dao.DaoVolFactory;
import model.Compagnie;
import model.CompagnieVol;
import model.CompagnieVolKey;
import model.Vol;

public class TestCompagnieVol {
	private static DaoCompagnieVol daoCompagnieVol;
	private static DaoCompagnie daoCompagnie;
	private static DaoVol daoVol;

	@BeforeClass
	public static void initDao() {
		daoCompagnieVol = DaoCompagnieVolFactory.getInstance();
		daoCompagnie = DaoCompagnieFactory.getInstance();
		daoVol = DaoVolFactory.getInstance();
	}

	@Test
	public void testCompagnieVol() {
		Compagnie compagnie = new Compagnie();
		compagnie.setNom("air_france");
		daoCompagnie.create(compagnie);
		assertNotNull(daoCompagnie.findByKey(compagnie.getIdCompagnie()));

		Vol vol = new Vol();
		daoVol.create(vol);
		assertNotNull(daoVol.findByKey(vol.getIdVol()));

		CompagnieVol compagnieVol = new CompagnieVol();
		compagnieVol.setKey(new CompagnieVolKey(compagnie, vol));
		daoCompagnieVol.create(compagnieVol);
		assertNotNull(daoCompagnieVol.findByKey(compagnieVol.getKey()));

//		daoCompagnieVol.delete(compagnieVol);
//		assertNull(daoCompagnieVol.findByKey(compagnieVol.getKey()));

		daoCompagnieVol.deleteByKey(compagnieVol.getKey());
		assertNull(daoCompagnieVol.findByKey(compagnieVol.getKey()));

		List<CompagnieVol> compagniesVols = daoCompagnieVol.findAll();
		System.out.println(compagniesVols);

	}

}
