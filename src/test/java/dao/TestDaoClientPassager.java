package dao;

import static org.junit.Assert.*;

import java.awt.List;
import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.DaoClientFactory;
import dao.DaoClient;
import dao.DaoPassagerFactory;
import model.Client;
import model.Reservation;
import util.Context;
import dao.DaoPassager;

public class TestDaoClientPassager {
	
	private static DaoClient daoClient;
	private static DaoPassager daoPassager;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		daoClient = DaoClientFactory.getInstance();
		daoPassager = DaoPassagerFactory.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		Context.destroy();
	}

	@Test
	public void test() {
		Client tanguy= new Client();
		Reservation reservationtanguy1= new Reservation();
		Reservation reservationtanguy2= new Reservation();

		java.util.List<Reservation> reservations= new ArrayList<>();
		reservations.add(reservationtanguy1);
		reservations.add(reservationtanguy2);
		
		daoClient.create(tanguy);
		tanguy.setClientName("saidani");
		tanguy.setReservations(reservations);
		
		assertNotNull(daoClient.findByKey(tanguy.getClientId()));
		assertNotNull(tanguy.getReservations());
		
		
		
		}

}
