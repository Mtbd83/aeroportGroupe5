package dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.Vol;
import util.Context;

public class DaoVolJpaImpl implements DaoVol{

	public void create(Vol objet) {
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
	public Vol findByKey(Integer key) {
		EntityManager em= Context.getInstance().getEntityManagerFactory().createEntityManager();
		Vol resa= null;
		resa = em.find(Vol.class, key);
		return resa;
	}



	@Override
	public Vol update(Vol objet) {
		EntityManager em= Context.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx=null;
		Vol a= null;
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
	public void delete(Vol objet) {
		EntityManager em= Context.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx=null;
		try {
		tx=em.getTransaction();
		tx.begin();
		em.remove(em.merge(objet));
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
		EntityTransaction tx=null;
		try {
		tx=em.getTransaction();
		tx.begin();
		em.remove(em.find(Vol.class, key));
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
	public List<Vol> findAll() {
		EntityManager em=Context.getInstance().getEntityManagerFactory().createEntityManager();
		Query query=em.createQuery("from Vol a");
		List<Vol> Vols=null;
		Vols=query.getResultList();
		em.close();
		return Vols;
	}

}