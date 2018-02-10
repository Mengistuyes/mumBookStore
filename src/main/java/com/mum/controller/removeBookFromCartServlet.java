package com.mum.controller;

import com.mum.dao.dataDao;
import com.mum.model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@WebServlet("/removeBookFromCartServlet")
public class removeBookFromCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double total=0.0;
        String isbn=request.getParameter("removedISBN");
        if(!isbn.trim().equalsIgnoreCase(""))
        {

            List<Book> listOfBooksInTheCart =dataDao.readFile();
            List<Book> listOfBooksInTheCartAfterRemoved=new ArrayList<Book>();
            for(Book book:listOfBooksInTheCart)
            {
                if(!book.getISBN().trim().equalsIgnoreCase(isbn.trim()))
                {
                    listOfBooksInTheCartAfterRemoved.add(book);
                }
            }
            if(listOfBooksInTheCartAfterRemoved!=null)
            {
               boolean trueOrFalse=dataDao.makeCartEmpty();
               if(trueOrFalse)
               {
                   for(Book book:listOfBooksInTheCartAfterRemoved)
                   {
                       total+=book.getPrice();
                      dataDao.saveCartToFile(book);
                   }
               }
            }
        }

        List<Book> books= new ArrayList<Book>();
        books= dataDao.readFile();
        request.setAttribute("total",total);
        request.setAttribute("BooksInCart",books);
        request.getRequestDispatcher("books.jsp").forward(request,response);

    }
}
