package dao;

public class DaoPassagerFactory {
	public static DaoPassager  daoPassager=null;
	private DaoPassagerFactory() {
	}
	public static DaoPassager getInstance() {
		
		if (daoPassager==null) {
			daoPassager=new DaoPassagerJpaImpl();
			
		}
		return daoPassager;
		
	}

}
