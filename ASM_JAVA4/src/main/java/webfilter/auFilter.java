package webfilter;

import java.io.IOException;

import constant.SessionLG;
import models.Users;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;

import javax.servlet.http.*;


@WebFilter({"/favorite/*","/share/*"})
public class auFilter implements Filter{

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) arg0;
        HttpServletResponse res = (HttpServletResponse) arg1;
        HttpSession session = req.getSession();
        Users admin = (Users) session.getAttribute(SessionLG.CURRENT_USER);
        if (admin == null) {
        	System.out.println(admin +"filter của tài khoản");
            session.setAttribute("errorMessage", "Vui lòng đăng nhập");
            res.sendRedirect("/ASM_JAVA4/login");
        }else {
        	arg2.doFilter(req, res);
        }
		
	}

}