package dao;

public class DaoCompagnieVolFactory {
	private static DaoCompagnieVol daoCompagnieVol = null;

	private DaoCompagnieVolFactory() {

	}

	public static DaoCompagnieVol getInstance() {
		if (daoCompagnieVol == null) {
			daoCompagnieVol = new DaoCompagnieVolJpaImpl();
		}
		return daoCompagnieVol;
	}
}
