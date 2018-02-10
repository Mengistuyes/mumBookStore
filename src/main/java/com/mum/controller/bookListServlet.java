package com.mum.controller;

import com.mum.dao.dataDao;
import com.mum.model.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class bookListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // super.doGet(req, resp);


//        List<Book> b= dataDao.getListOfBooks();
//
//        for (Book bo:b) {
//            boolean bookSavedOrNot=dataDao.saveBookToFile(bo);
//        }

        HttpSession oldSession = request.getSession(false);
        if (oldSession == null) {
            oldSession=request.getSession(true);
        }

        List<Book> books= new ArrayList<Book>();
       // books= dataDao.getListOfBooks();
        books= dataDao.getBooksFromFile();
        request.setAttribute("books",books);
        request.getRequestDispatcher("books.jsp").forward(request,response);

    }
}
