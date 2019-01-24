package com.mitrais.rms.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AuthenticationFilter")
public class AuthenticationFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest httpReq = (HttpServletRequest) req;
        HttpServletResponse httpRes = (HttpServletResponse) resp;

        String path = httpReq.getServletPath();
        HttpSession session = httpReq.getSession(false);
        boolean loggedIn = session != null && session.getAttribute("userId") != null;

        if(!loggedIn && path.contains("users"))
        {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login");
            requestDispatcher.forward(req, resp);
        }
        else if(path.equals("/login") && loggedIn)
        {
            httpRes.sendRedirect(httpReq.getContextPath());
        }
        else
        {
            chain.doFilter(req,resp);
        }


    }

    public void init(FilterConfig config) throws ServletException {

    }

}
