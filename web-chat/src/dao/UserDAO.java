package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import model.User;
import util.Active;
import util.HibernateUtil;

public class UserDAO {

	public void addUser(User user) throws SQLException {
		Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
        	e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
	}

	public void updateUser(User user) throws SQLException {
		Session session = null;
	       try {
	           session = HibernateUtil.getSessionFactory().openSession();
	           session.beginTransaction();
	           session.update(user);
	           session.getTransaction().commit();
	       } catch (Exception e) {
	    	   e.printStackTrace();
	       } finally {
	           if (session != null && session.isOpen()) {
	               session.close();
	           }
	       }
	}

	public void deleteUser(User user) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
       }
		
	}

	public User getUserById(Long id) throws SQLException {
		Session session = null;
		User user = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			user = session.load(User.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return user;
	}

	@SuppressWarnings("unchecked")
	public List<User> getActiveUsers() throws SQLException {
		Session session = null;
		List<User> users = new ArrayList<User>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			users.addAll(session.createCriteria(User.class).add(Restrictions.eq("active", Active.T)).list());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return users;
	}

	public User getUserByLogin(String login) throws SQLException {
		Session session = null;
		User user = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			user = (User) session.createCriteria(User.class).add(Restrictions.eq("login", login)).uniqueResult();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return user;
	}
}
