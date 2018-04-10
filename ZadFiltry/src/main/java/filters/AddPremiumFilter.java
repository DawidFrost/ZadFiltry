package filters;

import domain.UserApplication;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/addpremium")
public class AddPremiumFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();
		UserApplication user = (UserApplication) session.getAttribute("user");

		if (request.getParameter("username") == null || request.getParameter("username").equals("")
				|| request.getParameter("premium") == null || request.getParameter("premium").equals("")) {
			response.getWriter().print("Nie podano wszystkich parametrów");
			return;
		}

		if (user == null || ! user.getType().equals("admin")) {
			response.getWriter().print("Tylko admin ma dostep do strony AddPremium");
			return;
		}
		chain.doFilter(request, response);
	}

	public void destroy() {

	}
}
