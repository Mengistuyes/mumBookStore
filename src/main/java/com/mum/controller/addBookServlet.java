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
import java.util.List;
import java.util.UUID;

@WebServlet("/addBookServlet")
public class addBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // super.doPost(req, resp);
        String myTitle= request.getParameter("title");
        String myAuthor= request.getParameter("author");
        String myEdition= request.getParameter("edition");
        String myIsbn= request.getParameter("isbn");
        String myPublisher= request.getParameter("publisher");
        String myPrice= request.getParameter("price");
        String myFile= request.getParameter("file");
//        String myImagePath= request.getParameter("file");
        UUID bookId=UUID.randomUUID();

        Book book=new Book();
        HttpSession session=request.getSession();
        book.setBookId(bookId.toString());
        book.setTitle(myTitle);
        book.setAuthor(myAuthor);
        book.setEdition(myEdition);
        book.setISBN(myIsbn);
        book.setPublisher(myPublisher);
        book.setPrice(Double.parseDouble(myPrice));
        myFile="resources/images/cSharp.png";
        book.setImagePath(myFile);

//        List<Book> b= dataDao.getListOfBooks();
//
//        for (Book bo:b) {
//            boolean bookSavedOrNot=dataDao.saveBookToFile(bo);
//        }

        boolean isbnExistOrNot=dataDao.checkBookExistOrNot(book.getISBN());
        if(!isbnExistOrNot)
        {
            boolean bookSavedOrNot=dataDao.saveBookToFile(book);
            if(bookSavedOrNot)
            {
                Book addedBook= dataDao.getOneBookFromFile(bookId.toString());

                request.setAttribute("myBook",addedBook);
                request.getRequestDispatcher("bookDetail.jsp").forward(request,response);
            }
        }
        else
        {
            //If i have time i will display message
        }


//        boolean bookSavedOrNot=dataDao.saveBookToFile(book);
//        if(bookSavedOrNot)
//        {
//            Book addedBook= dataDao.getOneBookFromFile(bookId.toString());
//
//            request.setAttribute("myBook",addedBook);
//            request.getRequestDispatcher("bookDetail.jsp").forward(request,response);
//        }




    }
}
