package dao;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.DaoReservation;
import dao.DaoReservationFactory;
import model.Reservation;
import util.Context;
import java.util.Date;


public class daoReservationTest {
private static DaoReservation daoReservation;
	
	@BeforeClass
	public static void init() {
		daoReservation = DaoReservationFactory.getInstance();
	}
	
	
	@AfterClass
	public static void closeEmf() {
		Context.destroy();
	}
	
	/////////////////////////////////////////////////////
	
	
	@Test
	public void insertTest() {
		Reservation reservation= new Reservation ();
		assertNull(reservation.getNumeroReservation());
		daoReservation .create(reservation);
		assertNotNull(reservation.getNumeroReservation());
	}
	
	@Test
	public void findByKeyTest() {
		Reservation reservation= new Reservation ();
		daoReservation.create(reservation);
		assertNotNull(daoReservation.findByKey(reservation.getNumeroReservation()));
	}
	
	@Test
	public void updateTest() throws ParseException {
		Reservation reservation= new Reservation ();
		daoReservation.create(reservation);
		reservation = daoReservation.findByKey((reservation.getNumeroReservation()));
		SimpleDateFormat sdf = new SimpleDateFormat ("YYYY-MM-DD");
		reservation.setDateReservation(sdf.parse("2004-04-15"));
		daoReservation.update(reservation);
		assertEquals(sdf.parse("2004-04-15"), daoReservation.findByKey(reservation.getNumeroReservation()).getDateReservation());

	}
	
	@Test
	public void findAllTest() {
		assertNotNull(daoReservation.findAll());
	}
	
	@Test
	public void deleteTest() {
		Reservation reservation= new Reservation ();
		daoReservation.create(reservation);
		daoReservation.delete(reservation);
		assertNull(daoReservation.findByKey(reservation.getNumeroReservation()));
	}
	
	
	@Test
	public void deleteByKeyTest() {
		Reservation reservation= new Reservation ();
		daoReservation.create(reservation);
		daoReservation.deleteByKey(reservation.getNumeroReservation());
		assertNull(daoReservation.findByKey(reservation.getNumeroReservation()));
	}
	
	
}
