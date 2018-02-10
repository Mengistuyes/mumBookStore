package com.mum.controller;

import com.mum.dao.dataDao;
import com.mum.model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet ("/bookDetailServlet")
public class bookDetailServlet  extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        super.doGet(req, resp);
        String bookid=request.getParameter("q");

        Book book= dataDao.getOneBookFromFile(bookid);
     //   Book book= dataDao.getClickedBook(bookid);
        request.setAttribute("myBook",book);
//        HttpSession session=request.getSession();
//        session.setAttribute("book","book");
        request.getRequestDispatcher("bookDetail.jsp").forward(request,response);
    }
}
