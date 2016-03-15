package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Factory;
import model.User;
import util.Active;

@WebServlet("/Logout")
public class Logout extends Dispetcher {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		try {
			User user = Factory.getUserDAO().getUserByLogin(session.getAttribute("login").toString());
			if (user != null) {
				user.setActive(Active.F);
				Factory.getUserDAO().updateUser(user);
			}
			forward("/index.jsp", request, response);
		} catch (SQLException|NullPointerException e ) {
			forward("/error.jsp", request, response);
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
