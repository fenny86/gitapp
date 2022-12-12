package filter;

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

import bean.MemberBean;

/**
 * Servlet Filter implementation class checkManager
 */
@WebFilter(value = "*.safe")
public class checkManager implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		
		HttpSession session=req.getSession();
		MemberBean memberBean=(MemberBean) session.getAttribute("member");
		if(memberBean!=null) {
			chain.doFilter(req, res);
		}else {
			res.sendRedirect(req.getContextPath()+"/loginTest.jsp");
		}
	}

}
