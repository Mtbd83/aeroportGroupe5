package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.VilleAeroport;
import model.VilleAeroportKey;
import util.Context;

public class DaoVilleAeroportJpaImpl implements DaoVilleAeroport {

	public void create(VilleAeroport obj) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx =null;
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
			if (tx != null && em.isOpen()) {
				em.close();
			}
		}
	}

	public VilleAeroport findByKey(VilleAeroportKey key) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		VilleAeroport villeAeroport = null;
		villeAeroport = em.find(VilleAeroport.class, key);
		em.close();
		return villeAeroport;
	}

	public VilleAeroport update(VilleAeroport obj) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		VilleAeroport villeAeroport = null;
		try {
			tx.begin();
			villeAeroport = em.merge(obj);
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
		return villeAeroport;
	}

	public void delete(VilleAeroport obj) {
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

	public void deleteByKey(VilleAeroportKey key) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.remove(em.find(VilleAeroport.class, key));
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

	public List<VilleAeroport> findAll() {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("from VilleAeroport ville_aeroport");
		List<VilleAeroport> villeAeroports = null;
		villeAeroports = query.getResultList();
		em.close();
		return villeAeroports;
	}
}
