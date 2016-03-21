package servlets;

import java.sql.SQLException;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import dao.Factory;
import model.User;
import util.Active;

/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
@WebListener
public class SessionListener implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
	}

	public void sessionDestroyed(HttpSessionEvent arg) {
		synchronized (this) {
			HttpSession session = arg.getSession();
			User user = null;
			user = (User) session.getAttribute("user");
			if (user != null) {
				user.setActive(Active.F);
				try {
					Factory.getUserDAO().updateUser(user);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				session.removeAttribute("user");
			}
			session.removeAttribute("login");
		}
	}

}
