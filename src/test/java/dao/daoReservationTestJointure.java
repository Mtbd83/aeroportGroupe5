package dao;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.DaoClient;
import dao.DaoClientFactory;
import dao.DaoPassager;
import dao.DaoPassagerFactory;
import dao.DaoReservation;
import dao.DaoReservationFactory;
import model.Client;
import model.Passager;
import model.Reservation;
import util.Context;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class daoReservationTestJointure {
private static DaoReservation daoReservation;
private static DaoPassager daoPassager;
private static DaoClient daoClient;
	
	@BeforeClass
	public static void init() {
		daoReservation = DaoReservationFactory.getInstance();
		daoPassager = DaoPassagerFactory.getInstance();
		daoClient = DaoClientFactory.getInstance();
	}
	
	
	@AfterClass
	public static void closeEmf() {
		Context.destroy();
	}
	
	/////////////////////////////////////////////////////
	
	
	@Test
	public void Test() {
		
		
		Passager passager = new Passager();
		daoPassager.create(passager);
		assertNotNull(passager.getIdPassager());
		
		Client client = new Client();
		daoClient.create(client);
		assertNotNull(client.getClientId());
		
		Reservation reservation= new Reservation ();
		daoReservation .create(reservation);
		assertNotNull(reservation.getNumeroReservation());
		
		reservation.setPassager(passager);
		daoReservation.update(reservation);
		reservation.setClient(client);
		daoReservation.update(reservation);

		
		
		assertNotNull(reservation.getClient());
	
//		List<Reservation> reservations = new ArrayList<>();
//		reservations.add(reservation);
//		
//		passager.setReservations(reservations);
		assertNotNull(passager.getReservations());



		
		
		
		
		
	}
	


	
	
}
