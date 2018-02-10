package com.mum.controller;
import com.mum.model.User;
import com.mum.model.User1;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
    //private static  int Support_ticket_id=0;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Support_ticket_id++;
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        String cpass = request.getParameter("cpass");
        String fname = request.getParameter("firstname");
        String lname = request.getParameter("lastname");
        User user = new User();
        user.setLName(lname);
        user.setfName(fname);
        user.setEmail(email);
        user.setPassword(pass);
        user.setUserName(name);
        List<User> users = new ArrayList<>();
        users.add(user);
        ServletContext sc = this.getServletContext();
        String support =  sc.getInitParameter("support-email");
        out.print("Hi "+ fname +". Now You are a member of MUM book store \n Your user  is "+name +"@mum.com. ");
        out.print("<p>Thank you!  " + name +" for signing up. You should receive reply from " +
                "us with in few minutes in" + " \n your email address "+ email + "\n"+
                ". Let us know in our support email "+ support+". </p>" );
    }


}
