package work.jianhang.service.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CheckLoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();
        String url = req.getRequestURI();
        //Admin user = (Admin) session.getAttribute("user");
        //if (user == null && (!url.endsWith("/login.html")) && (!url.endsWith("/loginUser")) && (!url.endsWith("/login.css"))&&(!url.endsWith(".gif"))&&(!url.endsWith(".png"))) {
        //    res.sendRedirect(req.getContextPath() + "/login.html");
        //} else {
            filterChain.doFilter(servletRequest, servletResponse);
        //}

    }

    @Override
    public void destroy() {

    }
}
