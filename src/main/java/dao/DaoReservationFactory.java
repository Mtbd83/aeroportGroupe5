package dao;

public class DaoReservationFactory {
	
	public static DaoReservation daoReservation=null;
	
	private DaoReservationFactory() {
	}
	
	public static DaoReservation getInstance() {
		
		if (daoReservation==null) {
			daoReservation= new DaoReservationJpaImpl();
			
		}
		return daoReservation;
		
	}
}
