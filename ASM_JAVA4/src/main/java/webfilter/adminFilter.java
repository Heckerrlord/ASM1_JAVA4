package webfilter;

import java.io.IOException;

import constant.SessionLG;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Users;

@WebFilter("/admin/*")
public class adminFilter implements Filter{

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) arg0;
        HttpServletResponse res = (HttpServletResponse) arg1;
        HttpSession session = req.getSession();
        Users admin = (Users) session.getAttribute(SessionLG.CURRENT_USER);
        if (admin == null) {
            session.setAttribute("errorMessage", "Vui lòng đăng nhập");
            res.sendRedirect("/ASM_JAVA4/login");
        }else  if (admin.isAdmin()== false) {
        	System.out.println(admin + "filter");
        	session.removeAttribute(SessionLG.CURRENT_USER);
            session.setAttribute("errorMessage", "Vui lòng đăng nhập với tài khoản admin");
            res.sendRedirect("/ASM_JAVA4/login");
        } else {
        	arg2.doFilter(req, res);
        }
		
	}

}
