package dao;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import model.Aeroport;
import model.Compagnie;
import model.CompagnieVol;
import model.CompagnieVolKey;
import model.Escale;
import model.EscaleKey;
import model.Ville;
import model.VilleAeroport;
import model.VilleAeroportKey;
import model.Vol;

public class TestClement {
	private static DaoAeroport daoAeroport;
	private static DaoCompagnie daoCompagnie;
	private static DaoVille daoVille;
	private static DaoVol daoVol;
	private static DaoCompagnieVol daoCompagnieVol;
	private static DaoVilleAeroport daoVilleAeroport;
	private static DaoEscale daoEscale;

	@BeforeClass
	public static void initDao() {
		daoAeroport = DaoAeroportFactory.getInstance();
		daoCompagnie = DaoCompagnieFactory.getInstance();
		daoVille = DaoVilleFactory.getInstance();
		daoVol = DaoVolFactory.getInstance();
		daoCompagnieVol = DaoCompagnieVolFactory.getInstance();
		daoVilleAeroport = DaoVilleAeroportFactory.getInstance();
		daoEscale = DaoEscaleFactory.getInstance();
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

	@Test
	public void testVilleAeroport() {
		Ville ville = new Ville();
		ville.setNom("Paris");
		daoVille.create(ville);
		Aeroport aeroport = new Aeroport();
		aeroport.setIdAeroport(5);
		daoAeroport.create(aeroport);
		VilleAeroport villeAeroport = new VilleAeroport();
		villeAeroport.setKey(new VilleAeroportKey(ville, aeroport));
		daoVilleAeroport.create(villeAeroport);
		assertNotNull(villeAeroport.getKey());
		ville = new Ville();
		ville.setNom("New York");
		daoVille.create(ville);
		villeAeroport = new VilleAeroport();
		villeAeroport.setKey(new VilleAeroportKey(ville, aeroport));
		daoVilleAeroport.create(villeAeroport);
		assertNotNull(villeAeroport.getKey());
	}

	@Test
	public void testEscale() {
		Vol vol = new Vol();
		vol.setIdVol(2);
		daoVol.create(vol);
		Aeroport aeroport = new Aeroport();
		aeroport.setIdAeroport(5);
		daoAeroport.create(aeroport);
		Escale escale = new Escale();
		escale.setKey(new EscaleKey(vol, aeroport));
		daoEscale.create(escale);
		assertNotNull(escale.getKey());
		vol = new Vol();
		vol.setIdVol(3);
		daoVol.create(vol);
		escale = new Escale();
		escale.setKey(new EscaleKey(vol, aeroport));
		daoEscale.create(escale);
		assertNotNull(escale.getKey());
	}
}
