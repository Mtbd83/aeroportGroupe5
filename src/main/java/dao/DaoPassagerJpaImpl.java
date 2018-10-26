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

public class DaoPassagerJpaImpl implements DaoPassager{
	@Override
	public void create(Passager obj) {
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
	public Passager findByKey(Integer key) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		Passager p = null;
		p = em.find(Passager.class, key);
		em.close();

		return p;
	}

	@Override
	public Passager update(Passager obj) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		// permet de creer un singleton au lieu de charger la couche hibernate à chaque
		// lancer
		EntityTransaction tx = em.getTransaction();
		Passager p=null;
		try {
			tx.begin();
			p=em.merge(obj);
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
	public void delete(Passager obj) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		// permet de creer un singleton au lieu de charger la couche hibernate à chaque
		// lancer
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			obj = em.merge(obj); // obj peut etre manage
			// set la reservation a null
			
			Set<Reservation> reservations = (Set<Reservation>) obj.getReservations();
			if(reservations!=null) {
				for(Reservation r: reservations) {
				r.setNumeroReservation(null);
				}
			}
			
			em.remove(em.merge(obj));
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
	public void deleteByKey(Integer key) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		// permet de creer un singleton au lieu de charger la couche hibernate à chaque
		// lancer
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			Passager obj = em.merge(em.find(Passager.class, key)); // obj peut etre manage
			// set la reservation a null
			
			Set<Reservation> reservations = (Set<Reservation>) obj.getReservations();
			if(reservations!=null) {
				for(Reservation r: reservations) {
				r.setNumeroReservation(null);
				}
			}
			
			em.remove(em.merge(obj));
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
	public List<Passager> findAll() {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("from Passager p");
		// le select n'est pas obligatoire si on veut recuperer toutes les instances de
		// l'entite Passager
		List<Passager> Passagers = null;
		Passagers = query.getResultList();
		em.close();
		return Passagers;
	}
}
