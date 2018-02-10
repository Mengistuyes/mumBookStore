package com.mum.controller;

import com.google.gson.JsonObject;
import com.mum.dao.dataDao;
import com.mum.model.Book;
import com.mum.model.Cart;
import com.mum.service.cartService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.google.gson.Gson;

//@WebServlet("/shoppingCartServlet")
public class shoppingCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String sessionID = null;
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("JSESSIONID"))
                    sessionID = cookie.getValue();
            }
        }

       String fileName=sessionID.trim();
        if(fileName!=null || !fileName.trim().equalsIgnoreCase(""))
        {
            fileName=fileName + ".json";
        }
        else
        {

        }

        List<Book> listOfBooksInTheCart =dataDao.readCartFromFileWithFileName(fileName);//read Cart using session id
      //  List<Book> listOfBooksInTheCart =dataDao.readFile();//read Cart
        double total=0.0;
        int count=0;
        int totalItemsInTheCart=0;
        if(listOfBooksInTheCart!=null)
        {
                for(Book b:listOfBooksInTheCart)
                {
                    count+=0;
                    total+=b.getPrice();
                    totalItemsInTheCart++;
                }



                request.setAttribute("itemCount",totalItemsInTheCart);
                request.setAttribute("total", total);
                request.setAttribute("BooksInCart", listOfBooksInTheCart);
                request.getRequestDispatcher("/displayCart.jsp").forward(request,response);
            }
        else
        {
            PrintWriter out=response.getWriter();
//            out.print("<font color='red' >No item added</font>");
            request.getRequestDispatcher("/noItemAddedIntheCart.jsp").include(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //super.doPost(req, resp);

        String sessionID = null;
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                 if(cookie.getName().equals("JSESSIONID"))
                     sessionID = cookie.getValue();
            }
        }
        String fileName=sessionID.trim();
        if(fileName!=null || !fileName.trim().equalsIgnoreCase(""))
        {
            fileName=fileName + ".json";
        }
        String isbn=request.getParameter("isbn");
        String id=request.getParameter("id");
        String title=request.getParameter("title");
        String author=request.getParameter("author");
        String publisher=request.getParameter("publisher");
        String edition=request.getParameter("edition");
        String price=request.getParameter("price");
        String imagePath=request.getParameter("imagePath");

        Book book=new Book();

        book.setBookId(id);
        book.setTitle(title);
        book.setAuthor(author);
        book.setEdition(edition);
        book.setISBN(isbn);
        book.setPublisher(publisher);
        book.setImagePath(imagePath);
        book.setPrice(Double.parseDouble(price));

        //String path=getServletContext().getContextPath("resources/dataFiles/cart.json");
//        String path=getServletContext().getRealPath("resources/dataFiles/cart.json");
//        PrintWriter p=response.getWriter();
//        p.print(path);
        List<Book> booksExistInTheCart =dataDao.readCartFromFileWithFileName(fileName);
        List<Book> listOfBooksInTheCart=dataDao.aCartWithFileName(book,fileName);
        if(booksExistInTheCart!=null)//file already exist
        {
            boolean bookExistOrNot=false;
            for (Book b : booksExistInTheCart) {
                if (b.getISBN().equalsIgnoreCase(book.getISBN())) {
                    bookExistOrNot=true;
                }
            }
            if(!bookExistOrNot)
            {
//                List<Book> listOfBooksInTheCart=dataDao.aCartWithFileName(book,fileName);
                //   List<Book> listOfBooksInTheCart=dataDao.aCart(book);
                request.setAttribute("listOfBooksInTheCart",listOfBooksInTheCart);
                request.getRequestDispatcher("/dispalyCart.jsp").forward(request,response);
            }
        }
        else
        {
//            List<Book> listOfBooksInTheCart=dataDao.aCartWithFileName(book,fileName);
            //   List<Book> listOfBooksInTheCart=dataDao.aCart(book);
            request.setAttribute("listOfBooksInTheCart",listOfBooksInTheCart);
            request.getRequestDispatcher("/dispalyCart.jsp").forward(request,response);
        }
        response.setContentType("application/json");
        String itemCount="{itemCount:totalItemsInTheCart}";
        // 6. Send List<Article> as JSON to client

        if(listOfBooksInTheCart!=null)
        {

        }
//        Gson gson = new Gson();
//        JsonObject myObj=new JsonObject();
//        myObj.addProperty("numberOfItemsInTheCart",count);
//        response.getWriter().write(myObj.toString());
    }
}
