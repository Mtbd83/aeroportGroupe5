package dao;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.DaoPassager;
import dao.DaoPassagerFactory;
import dao.DaoReservation;
import dao.DaoReservationFactory;
import model.Passager;
import model.Reservation;
import util.Context;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class daoPassagerResaTest {
private static DaoReservation daoReservation;
private static DaoPassager daoPassager;
	
	@BeforeClass
	public static void init() {
		daoReservation = DaoReservationFactory.getInstance();
		daoPassager = DaoPassagerFactory.getInstance();
	}
	
	
	@AfterClass
	public static void closeEmf() {
		Context.destroy();
	}
	
	/////////////////////////////////////////////////////
	
	
	@Test
	public void Test() {
		Reservation reservation= new Reservation ();
		daoReservation .create(reservation);
		assertNotNull(reservation.getNumeroReservation());
		
		Passager passager = new Passager();
		daoPassager.create(passager);
		assertNotNull(passager.getIdPassager());
		
		List<Reservation> reservations = new ArrayList<>();
		reservations.add(reservation);
		
		passager.setReservations(reservations);
		assertNotNull(passager.getReservations());
		
		
		



	}
	


	
	
}
