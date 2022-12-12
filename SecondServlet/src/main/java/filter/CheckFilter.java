package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.AccountManager;
@WebFilter(value = "*.safe")
public class CheckFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		
		HttpSession session=req.getSession();
		AccountManager emp=(AccountManager) session.getAttribute("manager");
		if(emp!=null) {
			chain.doFilter(req, res);
		}else {
			res.sendRedirect(req.getContextPath()+"/login.html");
		}
	}

}
