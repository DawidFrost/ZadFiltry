package filters;

import domain.UserApplication;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/premium.jsp")
public class PremiumFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();
		UserApplication user = (UserApplication) session.getAttribute("user");

		if (user == null || ! (user.getType().equals("admin") || user.getType().equals("premium"))) {
			response.getWriter().print("Nie jestes uzytkownikiem premium");
			return;
		}

		chain.doFilter(request, response);
	}

	public void destroy() {

	}
}
