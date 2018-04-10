package servlets;

import repository.HSQLrepositry;
import repository.UserApplicationRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addpremium")
public class AddPremiumServlet extends HttpServlet {

	private UserApplicationRepository repository;

	@Override
	public void init() throws ServletException {
		repository = new HSQLrepositry();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if (req.getParameter("premium").equals("add")) {
			repository.setPremium(req.getParameter("username"));
		} else {
			repository.removePremium(req.getParameter("type"));
		}

	}
}
