package dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import dao.DaoAeroport;
import dao.DaoAeroportFactory;
import dao.DaoVille;
import dao.DaoVilleAeroport;
import dao.DaoVilleAeroportFactory;
import dao.DaoVilleFactory;
import model.Aeroport;
import model.Ville;
import model.VilleAeroport;
import model.VilleAeroportKey;

public class TestVilleAeroport {
	private static DaoVille daoVille;
	private static DaoAeroport daoAerport;
	private static DaoVilleAeroport daoVilleAeroport;

	@BeforeClass
	public static void initDao() {
		daoVille = DaoVilleFactory.getInstance();
		daoAerport = DaoAeroportFactory.getInstance();
		daoVilleAeroport = DaoVilleAeroportFactory.getInstance();
	}

	@Test
	public void test() {
		Ville ville = new Ville();
		ville.setNom("paris");
		daoVille.create(ville);
		assertNotNull(daoVille.findByKey(ville.getIdVille()));

		Aeroport aeroport = new Aeroport();
		aeroport.setNom("orly");
		daoAerport.create(aeroport);
		assertNotNull(daoAerport.findByKey(aeroport.getIdAeroport()));

		VilleAeroport villeAeroport = new VilleAeroport();
		villeAeroport.setKey(new VilleAeroportKey(ville, aeroport));
		daoVilleAeroport.create(villeAeroport);
		assertNotNull(daoVilleAeroport.findByKey(villeAeroport.getKey()));

//		daoVilleAeroport.delete(villeAeroport);
//		assertNull(daoVilleAeroport.findByKey(villeAeroport.getKey()));

		List<VilleAeroport> villesAeroports = daoVilleAeroport.findAll();
		System.out.println(villesAeroports);
	}

}
