package com.mum.filters;

import com.mum.dao.dataDao;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class LoginFilter implements Filter {
    private FilterConfig config;

    /** Creates new SessionFilter */
    public LoginFilter() {
    }

    public void init(FilterConfig filterConfig) throws ServletException {

        System.out.println("Instance created of " + getClass().getName());
        this.config = filterConfig;
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        HttpSession session = ((HttpServletRequest) request).getSession();
        ServletContext context = config.getServletContext();
        /*
         * use the ServletContext.log method to log filter messages
         */
        context.log("doFilter called in: " + config.getFilterName() + " on "
                + (new java.util.Date()));

        // log the session ID
        context.log("session ID: " + session.getId());

        // Find out whether the logged-in session attribute is set
        String logged = (String) session.getAttribute("logged-in");
        if (logged == null)
            session.setAttribute("logged-in", "no");

        //log a message about the log-in status
        context.log("log-in status: "
                + (String) session.getAttribute("logged-in"));
        context.log("");
        chain.doFilter(request, response);
    }

    public void destroy() {
        /*
         * called before the Filter instance is removed from service by the web
         * container
         */
    }



}
