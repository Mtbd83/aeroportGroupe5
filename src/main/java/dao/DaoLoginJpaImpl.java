package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.Login;
import util.Context;

public class DaoLoginJpaImpl implements DaoLogin{

	@Override
	public void create(Login objet) {
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
	public Login findByKey(Integer key) {
		EntityManager em= Context.getInstance().getEntityManagerFactory().createEntityManager();
		Login a= null;
		a = em.find(Login.class, key);
		return a;
	}

	@Override
	public Login update(Login objet) {
		EntityManager em= Context.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx=null;
		Login a= null;
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
	public void delete(Login objet) {
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
		em.remove(em.find(Login.class, key));
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
	public List<Login> findAll() {
		EntityManager em=Context.getInstance().getEntityManagerFactory().createEntityManager();
		Query query=em.createQuery("from Login a");
		List<Login> logins=null;
		logins=query.getResultList();
		em.close();
		return logins;
	}

}