package les5Fantastiques;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import util.Context;

public class volTest {
	
	   private static EntityManagerFactory emf = null;    
	   private EntityManager em = null;    
	   
	   @BeforeClass    
	   public static void initEntityManagerFactory() {        
		   emf = Persistence.createEntityManagerFactory("les5Fantastiques");   
		   }
	
	    @AfterClass   
	    public static void closeEntityManagerFactory() {        
	    	emf.close();    
	    	}   
	    @Before    
	    public void initEntityManager() {        
	    	em = emf.createEntityManager();   
	    	}    
	    @After    
	    public void closeEntityManager() {        
	    	em.close();    }
	
	@Test
	public void test() {
        assertNotNull(emf);        
        assertNotNull(em);
		
		
	}
		 


}
