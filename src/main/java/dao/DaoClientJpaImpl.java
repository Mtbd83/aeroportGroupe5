package dao;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.Client;
import model.Login;
import model.Passager;
import util.Context;

public class DaoClientJpaImpl implements DaoClient {
	@Override
	public void create(Client obj) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		// permet de creer un singleton au lieu de charger la couche hibernate à chaque
		// lancer
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(obj);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
		}
	}

	@Override
	public Client findByKey(Integer key) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		Client a = null;
		a = em.find(Client.class, key);
		em.close();

		return a;
	}

	@Override
	public Client update(Client obj) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		// permet de creer un singleton au lieu de charger la couche hibernate à chaque
		// lancer
		EntityTransaction tx = em.getTransaction();
		Client p = null;

		try {
			tx.begin();
			p = em.merge(obj);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
		}
		return p;
	}

	@Override
	public void delete(Client obj) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			obj = em.merge(obj); // obj peut etre manage
			// supprime les reservations
			Set<Reservation> reservations = (Set<Reservation>) obj.getReservations();
			for (Reservation r : reservations) { // permet de suprimer en cascade avec les articles correspondants au
													// film
				em.remove(r);
			}
			// supprime le login
			Login l = obj.getLogin();
			if (l != null) {
				em.remove(l);
			}

//			tx.begin();
//			em.remove(em.merge(obj));
//			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
		}
	}

	@Override
	public void deleteByKey(Integer key) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			Client obj = em.merge(em.find(Client.class, key)); // obj peut etre manage
			// supprime les reservations
			Set<Reservation> reservations = (Set<Reservation>) obj.getReservations();
			for (Reservation r : reservations) { // permet de suprimer en cascade avec les articles correspondants au
													// film
				em.remove(r);
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
		}
	}

	@Override
	public List<Client> findAll() {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("from Client a");
		List<Client> Clients = null;
		Clients = query.getResultList();
		em.close();
		return Clients;
	}

}
