package dao;

public class DaoAdresseFactory {
	
	public static DaoAdresse  daoAdresse=null;
	private DaoAdresseFactory() {
	}
	public static DaoAdresse getInstance() {
		
		if (daoAdresse==null) {
			daoAdresse=new DaoAdresseJpaImpl();
			
		}
		return daoAdresse;
		
	}
}
