package com.mum.controller;
import com.mum.model.User;
import com.mum.dao.dataDao;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/loginServlet")
//@WebServlet("/com/mum/controller/loginServlet")
public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("username");
        String pass = req.getParameter("password");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        try {

            User user = new User(uname,pass);

            if (dataDao.isValid(user)) {
//                HttpSession session=req.getSession();
//                session.setAttribute("username",uname);
//                req.getRequestDispatcher("index.jsp").include(req, resp);
//                //resp.sendRedirect("books.jsp");



                HttpSession oldSession = req.getSession(false);
                if (oldSession != null) {
                    oldSession.invalidate();
                }

                HttpSession newSession = req.getSession(true);
                Cookie c = new Cookie("JSESSIONID", newSession.getId());
                resp.addCookie(c);
                newSession.setMaxInactiveInterval(15*60);
                req.getRequestDispatcher("addBook.jsp").include(req, resp);
            }
            else
            {   out.print("<font color='red' >Sorry, Wrong  username or password! Please enter again  Correctly</font>");
                req.getRequestDispatcher("login.jsp").include(req, resp);

            }
            out.close();

        }
        catch (Throwable theException)
        {
            System.out.println(theException);
        }

    }
}