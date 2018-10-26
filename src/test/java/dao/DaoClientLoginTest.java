package dao;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.DaoAdresse;
import dao.DaoAdresseFactory;
import dao.DaoClient;
import dao.DaoClientFactory;
import dao.DaoLogin;
import dao.DaoLoginFactory;
import model.Adresse;
import model.Client;
import model.Login;
import model.Titre;
import util.Context;

public class DaoClientLoginTest {
	private static DaoClient daoClient;
	private static DaoLogin daoLogin;
	private static DaoAdresse daoAdresse;

	@BeforeClass
	public static void initDao() {
		daoClient = DaoClientFactory.getInstance();
		daoLogin = DaoLoginFactory.getInstance();
		daoAdresse=DaoAdresseFactory.getInstance();
	}

	@AfterClass
	public static void close() {
		Context.destroy();
	}

	@Test
	public void testClientLogin() {
		Login login = new Login("SuperDude", "HereISaveTheDayAgain");
		daoLogin.create(login);
		Adresse adresse=new Adresse("TheFarm",15278,"Smallville","USA");
		daoAdresse.create(adresse);
		Client client = new Client();
		client.setClientName("Kal El");
		client.setMail("SuperDotManAtKryptonDotCom");
		client.setNumeroTel(25);
		client.setTitre(Titre.M);
		client.setAdresse(adresse);
		client.setLogin(login);
		daoClient.create(client);
		assertEquals(login, daoClient.findByKey(client.getClientId()).getLogin());
		login.setClient(client);
		client.setLogin(login);
		daoClient.update(client);
		daoLogin.update(login);
		assertEquals(client, daoLogin.findByKey(login.getId()).getClient());
	}
}
