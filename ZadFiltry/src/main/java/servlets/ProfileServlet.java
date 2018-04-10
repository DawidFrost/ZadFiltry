package servlets;

import domain.UserApplication;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = req.getSession();

		UserApplication user = (UserApplication) session.getAttribute("user");

		response.getWriter().println(user.getUsername());
		response.getWriter().println(user.getEmail());
		response.getWriter().println(user.getType());
		return;
	}
}
