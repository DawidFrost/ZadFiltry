package filters;

import domain.UserApplication;
import repository.HSQLrepositry;
import repository.UserApplicationRepository;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/login")
public class LoginFilter implements Filter {

	private UserApplicationRepository repository;

	public void init(FilterConfig filterConfig) throws ServletException {
		repository = new HSQLrepositry();

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();
		if (request.getParameter("username") == null || request.getParameter("username").equals("")
				|| request.getParameter("password") == null || request.getParameter("password").equals("")) {
			response.getWriter().print("Nie podano wszystkich parametrów");
			return;
		}

		UserApplication user = repository.getApplicationByUsername(request.getParameter("username"));
		if (user == null) {
			response.getWriter().print("uzytkownika nie ma w bazie");
			return;
		}
		if (! user.getPassword().equals(request.getParameter("password"))) {
			response.getWriter().print(("Haslo jest nieprawidlowe"));
			return;
		}
		session.setAttribute("user", user);

		chain.doFilter(request, response);
	}

	public void destroy() {

	}
}
