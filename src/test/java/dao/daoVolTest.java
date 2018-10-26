package dao;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.DaoVol;
import dao.DaoVolFactory;
import model.Vol;
import util.Context;
import java.util.Date;


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
	
	@Test
	public void findByKeyTest() {
		Vol vol= new Vol ();
		daoVol.create(vol);
		assertNotNull(daoVol.findByKey(vol.getIdVol()));
	}
	
	@Test
	public void updateTest() throws ParseException {
		Vol vol= new Vol ();
		daoVol.create(vol);
		vol = daoVol.findByKey((vol.getIdVol()));
		SimpleDateFormat sdf = new SimpleDateFormat ("YYYY-MM-DD");
		vol.setDateArrivee(sdf.parse("2001-04-15"));
		daoVol.update(vol);
		assertEquals(sdf.parse("2001-04-15"), daoVol.findByKey(vol.getIdVol()).getDateArrivee());

	}
	
	@Test
	public void findAllTest() {
		assertNotNull(daoVol.findAll());
	}
	
	@Test
	public void deleteTest() {
		Vol vol= new Vol ();
		daoVol.create(vol);
		daoVol.delete(vol);
		assertNull(daoVol.findByKey(vol.getIdVol()));
	}
	
	
	@Test
	public void deleteByKeyTest() {
		Vol vol= new Vol ();
		daoVol.create(vol);
		daoVol.deleteByKey(vol.getIdVol());;
		assertNull(daoVol.findByKey(vol.getIdVol()));
	}
	
	
}
