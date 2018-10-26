package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.Aeroport;
import util.Context;

public class DaoAeroportJpaImpl implements DaoAeroport {

	@Override
	public void create(Aeroport obj) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
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
	public Aeroport findByKey(Integer key) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		Aeroport aeroport = null;
		aeroport = em.find(Aeroport.class, key);
		em.close();
		return aeroport;
	}

	@Override
	public Aeroport update(Aeroport obj) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		Aeroport aeroport = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			aeroport = em.merge(obj);
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
		return aeroport;
	}

	@Override
	public void delete(Aeroport obj) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
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
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.remove(em.merge(em.find(Aeroport.class, key)));
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
	public List<Aeroport> findAll() {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		List<Aeroport> aeroports = null;
		Query query = em.createQuery("from Aeroport a");
		aeroports = query.getResultList();
		em.close();
		return aeroports;
	}

}
