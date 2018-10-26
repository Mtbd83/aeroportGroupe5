package dao;

public class DaoCompagnieFactory {
	private static DaoCompagnie daoCompagnie = null;

	private DaoCompagnieFactory() {

	}

	public static DaoCompagnie getInstance() {
		if (daoCompagnie == null) {
			daoCompagnie = new DaoCompagnieJpaImpl();
		}
		return daoCompagnie;
	}

}
