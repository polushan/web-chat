package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Factory;
import model.User;
import util.Active;
import util.History;

@WebServlet("/AddMessage")
public class AddMessage extends Dispetcher {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		History history = History.INSTANCE;
		User user = null;
		String who = request.getParameter("who");
		String message = request.getParameter("message");
		if (!"".equals(message.trim()) && message != null) {
			message = message.trim();
			if (!"".equals(who.trim()) && who != null) {
				who = who.trim();
				try {
					user = Factory.getUserDAO().getUserByLogin(who);
				} catch (SQLException e) {
					forward("/error.jsp", request, response);
					e.printStackTrace();
				}
				if (user != null) {
					// Здесь будет приватное общение
				}
			} else {
				history.addMessage(getTime() + " " + request.getSession().getAttribute("login") + "<br>" + message);
			}
		}
		forward("/chat.jsp", request, response);

	}

	protected void destroy(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<User> activeUsers = Factory.getUserDAO().getActiveUsers();
			for (User user : activeUsers) {
				user.setActive(Active.F);
				Factory.getUserDAO().updateUser(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private String getTime() {
		Date now = new Date();
		DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		String time = formatter.format(now);
		return time;
	}

}
