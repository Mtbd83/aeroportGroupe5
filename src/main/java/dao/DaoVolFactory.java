package dao;

public class DaoVolFactory {
	
	public static DaoVol daoVol=null;
	
	private DaoVolFactory() {
	}
	
	public static DaoVol getInstance() {
		
		if (daoVol==null) {
			daoVol= new DaoVolJpaImpl();
			
		}
		return daoVol;
		
	}
}
