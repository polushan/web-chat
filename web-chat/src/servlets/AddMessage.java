package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Message;

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
		String from = request.getSession().getAttribute("login").toString();
		String who = request.getParameter("who");
		String message = request.getParameter("message");
		if (!"".equals(message.trim()) && message != null) {
			message = message.trim();
			if (!"".equals(who.trim()) && who != null) {
				who = who.trim();
				history.addMessage(new Message(message, from,  who));
			} else {
				history.addMessage(new Message(message, from));
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

}
