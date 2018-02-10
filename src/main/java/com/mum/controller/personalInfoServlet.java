package com.mum.controller;

import com.mum.dao.dataDao;
import com.mum.model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@WebServlet("/personalInfoServlet")
public class personalInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = null;
        String sessionID = null;
        Cookie[] cookies = request.getCookies();
        if(cookies !=null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username"))
                    userName = cookie.getValue();
                if(cookie.getName().equals("JSESSIONID"))
                    sessionID = cookie.getValue();
            }
        }
                if(userName == null)
                    response.sendRedirect("signUp.jsp");


        String fileName=sessionID.trim();
        if(fileName!=null || !fileName.trim().equalsIgnoreCase(""))
        {
            fileName=fileName + ".json";
        }
        else
        {

        }
        boolean bool=dataDao.removeCart(fileName);
        if(bool) {
            response.sendRedirect("successfullySubmitted.jsp");
        }

    }

}