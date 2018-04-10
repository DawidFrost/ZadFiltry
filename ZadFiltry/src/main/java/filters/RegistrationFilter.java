package filters;

import repository.HSQLrepositry;
import repository.UserApplicationRepository;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/registration")
public class RegistrationFilter implements Filter {

	private UserApplicationRepository repository;

	public void init(FilterConfig filterConfig) throws ServletException {
		repository = new HSQLrepositry();

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if (request.getParameter("username").equals(null) || request.getParameter("username").equals("")
				|| request.getParameter("password").equals(null) || request.getParameter("password").equals("")
				|| request.getParameter("confirmpassword").equals(null) || request.getParameter("confirmpassword").equals("")
				|| request.getParameter("email").equals(null) || request.getParameter("email").equals("")) {
			response.getWriter().print("Nie podano wszystkich parametrów");
			return;
		}

		if (! request.getParameter("password").equals(request.getParameter("confirmpassword"))) {
			response.getWriter().print("Hasla nie sa takie samie");
			return;
		}
		if (repository.getApplicationByUsername(request.getParameter("username")) != null) {
			response.getWriter().print("uzytkownika jest juz w bazie");
			return;
		}

		chain.doFilter(request, response);

	}

	public void destroy() {

	}
}
