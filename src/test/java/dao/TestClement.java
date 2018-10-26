package dao;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import dao.DaoAeroport;
import dao.DaoAeroportFactory;
import dao.DaoCompagnie;
import dao.DaoCompagnieFactory;
import dao.DaoVille;
import dao.DaoVilleFactory;
import dao.DaoVol;
import dao.DaoVolFactory;
import model.Aeroport;
import model.Compagnie;
import model.Ville;
import model.Vol;

public class TestClement {
	private static DaoAeroport daoAeroport;
	private static DaoCompagnie daoCompagnie;
	private static DaoVille daoVille;
	private static DaoVol daoVol;

	@BeforeClass
	public static void initDao() {
		daoAeroport = DaoAeroportFactory.getInstance();
		daoCompagnie = DaoACompagnieFactory.getInstance();
		daoVille = DaoVilleFactory.getInstance();
		daoVille = DaoVolFactory.getInstance();
	}

	@Test
	public void testCompagnieVol() {
		Compagnie compagnie = new Compagnie();
		compagnie.setNom("Air France");
		daoCompagnie.create(compagnie);
		Vol vol = new Vol();
		vol.setIdVol(5);
		daoVol.create(vol);
		CompagnieVol compagnieVol = new CompagnieVol();
		compagnieVol.setKey(new CompagnieVolKey(compagnie, vol));
		daoCompagnieVol.create(compagnieVol);
		assertNotNull(compagnieVol.getKey());
		compagnie = new Compagnie();
		compagnie.setNom("British Airways");
		daoCompagnie.create(compagnie);
		compagnieVol = new CompagnieVol();
		compagnieVol.setKey(new CompagnieVolKey(compagnie, vol));
		daoCompagnieVol.create(compagnieVol);
		assertNotNull(compagnieVol.getKey());
	}
}
