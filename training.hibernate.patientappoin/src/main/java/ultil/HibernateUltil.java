package ultil;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUltil {

	private static SessionFactory sessionFactory;

	private static SessionFactory buildSessionFactory() {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");

		return config.buildSessionFactory();
	}

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			sessionFactory = buildSessionFactory();
		}

		return sessionFactory;
	}

}