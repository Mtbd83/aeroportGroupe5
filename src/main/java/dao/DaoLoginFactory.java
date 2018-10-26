package dao;

public class DaoLoginFactory {
	public static DaoLogin  daoLogin=null;
	private DaoLoginFactory() {
	}
	public static DaoLogin getInstance() {
		
		if (daoLogin==null) {
			daoLogin=new DaoLoginJpaImpl();
			
		}
		return daoLogin;
		
	}
}
