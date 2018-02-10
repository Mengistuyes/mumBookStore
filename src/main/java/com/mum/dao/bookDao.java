//package com.mum.dao;
//
//import com.mum.model.Book;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//public class bookDao {
//    private BookStoreService bookStoreServiceInstance = BookStoreService.getInstance();
//
//
//
////    public Map<String,String> addToCart(Book book){
////
////        List<Book> booksInCarts = bookStoreServiceInstance.getBooksInCart()!= null? bookStoreServiceInstance.getBooksInCart(): new ArrayList<Book>();
////
////        Map<String,String> status = new HashMap<String,String>();
////        if(book != null){
////            Book existingBookInCart = getBookInCart(booksInCarts, book);
////            if(existingBookInCart != null){
////                status.put("status","item exists");
////            }else{
////                status.put("status","item added successfully");
////                booksInCarts.add(book);
////            }
////
////            bookStoreServiceInstance.setBooksInCart(booksInCarts);
////
////            return status;
////        }
//}
