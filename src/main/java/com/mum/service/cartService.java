package com.mum.service;

import com.mum.dao.dataDao;
import com.mum.model.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class cartService {
    private static cartService instance = null;
    List<Book> listOfBooksInCart;

    public static cartService getInstance() {
        if (instance == null) {
            instance = new cartService();
            instance.getListOfBooksInTheCart();
        }
        return instance;
    }

    public List<Book> getListOfBooksInTheCart() {
        return listOfBooksInCart;
    }
}
