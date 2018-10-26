package dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.Adresse;
import util.Context;

public class DaoAdresseJpaImpl implements DaoAdresse{

	@Override
	public void create(Adresse objet) {
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
	public Adresse findByKey(Integer key) {
		EntityManager em= Context.getInstance().getEntityManagerFactory().createEntityManager();
		Adresse a= null;
		a = em.find(Adresse.class, key);
		return a;
	}

	@Override
	public Adresse update(Adresse objet) {
		EntityManager em= Context.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx=null;
		Adresse a= null;
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
	public void delete(Adresse objet) {
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
		em.remove(em.find(Adresse.class, key));
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
	public List<Adresse> findAll() {
		EntityManager em=Context.getInstance().getEntityManagerFactory().createEntityManager();
		Query query=em.createQuery("from Adresse a");
		List<Adresse> adresses=null;
		adresses=query.getResultList();
		em.close();
		return adresses;
	}
	

}