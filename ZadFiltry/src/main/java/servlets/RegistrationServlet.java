package servlets;

import domain.UserApplication;
import repository.HSQLrepositry;
import repository.UserApplicationRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	UserApplicationRepository repository;

	@Override
	public void init() throws ServletException {
		repository = new HSQLrepositry();
		repository.addAdmin();
	}

	private UserApplication retrieveApplicationFromRequest(HttpServletRequest request) {
		UserApplication result = new UserApplication();
		result.setUsername(request.getParameter("username"));
		result.setPassword(request.getParameter("password"));
		result.setType("user");
		result.setEmail(request.getParameter("email"));
		return result;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		repository.addUser((retrieveApplicationFromRequest(request)));
		response.getWriter().print("Udalo sie zarejestrowac uzytkownika");
	}

}
