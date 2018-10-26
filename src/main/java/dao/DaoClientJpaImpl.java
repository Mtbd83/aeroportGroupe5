package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.Client;
import util.Context;

public class DaoClientJpaImpl implements DaoClient{
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
			p =em.merge(obj);
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
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.remove(em.find(Client.class, key));
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
	public List<Client> findAll() {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		Query query= em.createQuery("from Client a");
		List<Client> Clients = null;
		Clients = query.getResultList();
		em.close();
		return Clients;
	}

}
