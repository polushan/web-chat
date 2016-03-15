package servlets;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.Factory;
import dao.UserDAO;
import model.User;
import util.Active;

@WebServlet("/Index")
public class Index extends Dispetcher {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("login").trim();
		String password = request.getParameter("password").trim();
		try {
			if ("".equals(login) || "".equals(password) || login == null || password == null) {
				forward("/index.jsp", request, response);
			} else {
				User user = null;
				UserDAO userDAO = Factory.getUserDAO();
				user = userDAO.getUserByLogin(login);
				if (user != null) {
					if (user.getPassword().trim().equals(password)) {
						user.setActive(Active.T);	
					} else {
						forward("/index.jsp", request, response);
					}
				} else {
					user = new User(login, password, Active.T);
					userDAO.addUser(user);
				}
				userDAO.updateUser(user);
				HttpSession session = request.getSession(true);
				session.setAttribute("user", user);
				session.setAttribute("login", login);
				forward("/chat.jsp", request, response);
			}
		} catch (SQLException e) {
			forward("/error.jsp", request, response);
			e.printStackTrace();
		}

	}

}