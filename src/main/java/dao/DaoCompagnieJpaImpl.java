package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.Aeroport;
import model.Compagnie;
import util.Context;

public class DaoCompagnieJpaImpl implements DaoCompagnie {

	@Override
	public void create(Compagnie obj) {
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
	public Compagnie findByKey(Integer key) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		Compagnie compagnie = null;
		compagnie = em.find(Compagnie.class, key);
		em.close();
		return compagnie;
	}

	@Override
	public Compagnie update(Compagnie obj) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		Compagnie compagnie = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			compagnie = em.merge(obj);
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
		return compagnie;
	}

	@Override
	public void delete(Compagnie obj) {
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
			em.remove(em.merge(em.find(Compagnie.class, key)));
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
	public List<Compagnie> findAll() {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		List<Compagnie> compagnies = null;
		Query query = em.createQuery("from Compagnie c");
		compagnies = query.getResultList();
		em.close();
		return compagnies;
	}

}
