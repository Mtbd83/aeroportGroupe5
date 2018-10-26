package dao;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Vol;
import util.Context;


public class daoVolTest {
private static DaoVol daoVol;
	
	@BeforeClass
	public static void init() {
		daoVol = DaoVolFactory.getInstance();
	}
	
	
	@AfterClass
	public static void closeEmf() {
		Context.destroy();
	}
	
	/////////////////////////////////////////////////////
	
	
	@Test
	public void insertTest() {
		Vol vol= new Vol ();
		assertNull(vol.getIdVol());
		daoVol .create(vol);
		assertNotNull(vol.getIdVol());
	}
	
//	@Test
//	public void findByKeyTest() {
//		Vol camille= new Vol (Titre.MLLE,"FindByKey","Camille");
//		daoVol.create(camille);
//		assertNotNull(daoVol.findByKey(camille.getNoVol()));
//	}
//	
//	@Test
//	public void updateTest() {
//		Vol ad= new Vol (Titre.MLLE,"Update","Camille");
//		daoVol.create(ad);
//		ad = daoVol.findByKey(ad.getNoVol());
//		ad.setNom("new up");
//		daoVol.update(ad);
//		assertEquals("new up", daoVol.findByKey(ad.getNoVol()).getNom());
//	}
//	
//	@Test
//	public void findAllTest() {
//		assertNotNull(daoVol.findAll());
//	}
//	
//	@Test
//	public void deleteTest() {
//		Vol ad= new Vol (Titre.MLLE,"Delete","Camille");;
//		daoVol.create(ad);
//		daoVol.delete(ad);
//		assertNull(daoVol.findByKey(ad.getNoVol()));
//	}
//	
//	
//	@Test
//	public void deleteByKeyTest() {
//		Vol ad= new Vol (Titre.MLLE,"Delete","Camille");
//		daoVol.create(ad);
//		daoVol.deleteByKey(ad.getNoVol());;
//		assertNull(daoVol.findByKey(ad.getNoVol()));
//	}
//	
	
}
