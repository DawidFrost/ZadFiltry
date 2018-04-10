package servlets;

import domain.UserApplication;
import repository.HSQLrepositry;
import repository.UserApplicationRepository;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/allusers")
public class AllUsersServlet extends HttpServlet {

	UserApplicationRepository repository;

	public void init() {
		repository = new HSQLrepositry();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		List<UserApplication> users = repository.getAll();
		for (UserApplication user : users) {
			resp.getWriter().println(user.getUsername() + " " + user.getType());
		}
	}
}
