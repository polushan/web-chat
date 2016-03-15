package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.Locale;

public class HibernateUtil {
	private static SessionFactory sessionFactory = null;
	static {
		try {
			Locale.setDefault(Locale.ENGLISH);
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
