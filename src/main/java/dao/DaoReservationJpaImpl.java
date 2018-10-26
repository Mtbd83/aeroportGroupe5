package dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.Client;
import model.Passager;
import model.Reservation;
import model.Vol;
import util.Context;

public class DaoReservationJpaImpl implements DaoReservation{

	public void create(Reservation objet) {
		EntityManager em= Context.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx=null;
		try {
		tx=em.getTransaction();
		tx.begin();
		em.persist(objet);
		tx.commit();
		}catch (Exception e){
			e.printStackTrace();
			if(tx!=null && tx.isActive()) {
				tx.rollback();
			}
		}finally {
			if(em!=null && em.isOpen()) {
				em.close();
			}
		}
	}

	@Override
	public Reservation findByKey(Integer key) {
		EntityManager em= Context.getInstance().getEntityManagerFactory().createEntityManager();
		Reservation resa= null;
		resa = em.find(Reservation.class, key);
		return resa;
	}



	@Override
	public Reservation update(Reservation objet) {
		EntityManager em= Context.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx=null;
		Reservation a= null;
		try {
		tx=em.getTransaction();
		tx.begin();
		a=em.merge(objet);
		tx.commit();
		}catch (Exception e){
			e.printStackTrace();
			if(tx!=null && tx.isActive()) {
				tx.rollback();
			}
		}finally {
			if(em!=null && em.isOpen()) {
				em.close();
			}
		}
		return a;
		
	}

	@Override
	public void delete(Reservation objet) {
		EntityManager em= Context.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx=em.getTransaction();;
		try {
			tx.begin();
			objet=em.merge(objet);
			Vol vol = objet.getVol();
			Passager passager = objet.getPassager();
			Client client = objet.getClient();
			if (vol!= null) {
				objet.setVol(null);
			}
			if (passager!= null) {
				objet.setPassager(null);;
			}
			if (client!= null) {
				objet.setClient(null);;
			}
			em.remove(objet);
			tx.commit();
		}catch (Exception e){
			e.printStackTrace();
			if(tx!=null && tx.isActive()) {
				tx.rollback();
			}
		}finally {
			if(em!=null && em.isOpen()) {
				em.close();
			}
		}
		
	}

	@Override
	public void deleteByKey(Integer key) {
		EntityManager em= Context.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx=em.getTransaction();
		try {
		Reservation objet=em.merge(em.find(Reservation.class,key));
		Vol vol = objet.getVol();
		Passager passager = objet.getPassager();
		Client client = objet.getClient();
		if (vol!= null) {
			objet.setVol(null);
		}
		if (passager!= null) {
			objet.setPassager(null);;
		}
		if (client!= null) {
			objet.setClient(null);;
		}
		tx.begin();
		em.remove(objet);
		tx.commit();
		}catch (Exception e){
			e.printStackTrace();
			if(tx!=null && tx.isActive()) {
				tx.rollback();
			}
		}finally {
			if(em!=null && em.isOpen()) {
				em.close();
			}
		}
		
	}

	@Override
	public List<Reservation> findAll() {
		EntityManager em=Context.getInstance().getEntityManagerFactory().createEntityManager();
		Query query=em.createQuery("from Reservation a");
		List<Reservation> Reservations=null;
		Reservations=query.getResultList();
		em.close();
		return Reservations;
	}

}