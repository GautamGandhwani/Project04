package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.co.rays.util.ServletUtility;

@WebFilter("/ctl/*")
public class FrontController implements Filter {

	@Override
	public void init(FilterConfig conf) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		HttpSession session = request.getSession(true);

		if (session.getAttribute("user") == null) {
			req.setAttribute("error", "Your session has been expired. Please Login again....");
			ServletUtility.redirect(ORSView.LOGIN_CTL, request, response);
		} else {
			chain.doFilter(req, resp);
		}
	}

	@Override
	public void destroy() {
	}

}
