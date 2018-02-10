package com.mum.controller;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/logout")
public class logout extends HttpServlet {

@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    response.setContentType("text/html");
    PrintWriter out=response.getWriter();

    request.getRequestDispatcher("login.jsp").include(request, response);
    HttpSession sess = request.getSession();
    sess.removeAttribute("username");
    sess.invalidate();


    out.print("You are successfully logged out!");

    out.close();
    }
}
