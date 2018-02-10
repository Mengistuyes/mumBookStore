package com.mum.dao;

import com.google.gson.Gson;
import com.mum.model.Book;
import com.mum.model.Cart;
import com.mum.model.User;
import com.mum.model.User1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class dataDao {
    private static dataDao instance = null;
    private static List<Cart> bookInCart;

    public static dataDao getInstance() {
        if (instance == null) {
            instance = new dataDao();
            instance.getListOfBooks();
        }
        return instance;
    }

    List<Book> listOfBooksInCart;

    public List<Cart> getbookInCart() {
        return bookInCart;
    }


    public static List<Book> getListOfBooks() {
        bookInCart= new ArrayList<>();
        List<Book> listOfBooks = new ArrayList<Book>();
        Book book = new Book();
        book.setTitle("Advanced Java");
        book.setAuthor("Abebe");
        book.setBookId("067e6162-3b6f-1ae2-a171-2470b63dff00");
        book.setEdition("1st Edition");
        book.setISBN("1111111111111");
        book.setPrice(25.25);
        book.setImagePath("resources/images/advancedJava.jpg");
        book.setPublisher("kebebush pub");
        listOfBooks.add(book);

        Book book1 = new Book();
        book1.setTitle("Html5");
        book1.setAuthor("Messi");
        book1.setBookId("067e6162-3b6f-2ae2-a171-2470b63dff00");
        book1.setEdition("2nd Edition");
        book1.setISBN("22222222222222");
        book1.setPrice(50.5);
        book1.setImagePath("resources/images/html5.jpg");
        book1.setPublisher("alemitu Pub");
        listOfBooks.add(book1);

        Book book2 = new Book();
        book2.setTitle("Advanced cSharp");
        book2.setAuthor("Esunew");
        book2.setBookId("067e6162-4b6f-4ae2-a171-2470b63dff00");
        book2.setEdition("3rd Edition");
        book2.setISBN("33333333333");
        book2.setPrice(25.25);
        book2.setImagePath("resources/images/cSharp.png");
        book2.setPublisher("demmelash pub");
        listOfBooks.add(book2);

        Book book3 = new Book();
        book3.setTitle("Html5");
        book3.setAuthor("lema");
        book3.setBookId("067e6162-3b6f-4ae2-a171-2470b63dff00");
        book3.setEdition("FirstEdition1");
        book3.setISBN("444444444");
        book3.setPrice(50.5);
        book3.setImagePath("resources/images/android.png");
        book3.setPublisher("Esubalew Pub");
        listOfBooks.add(book3);

        Book book4 = new Book();
        book4.setTitle("Android");
        book4.setAuthor("Almetam");
        book4.setBookId("067e6162-3b6f-4ae2-a171-2470b63dff00");
        book4.setEdition("FirstEdition1");
        book4.setISBN("55555555");
        book4.setPrice(50.5);
        book4.setImagePath("resources/images/android.png");
        book4.setPublisher("Alemu pub");
        listOfBooks.add(book4);
        return listOfBooks;
    }
//=====================================
public static List<Cart> getListOfBooksInCart() {
    List<Cart> listOfBooksInCart = new ArrayList<Cart>();
    Cart cart = new Cart();
    cart.setTitle("Advanced Java");
    cart.setAuthor("Iniesta");
    cart.setBookId("067e6162-3b6f-1ae2-a171-2470b63dff00");
    cart.setEdition("FirstEdition");
    cart.setISBN("1111111111111");
    cart.setPrice(25.25);
    cart.setImagePath("resources/images/advancedJava.jpg");
    cart.setPublisher("Barcelona");
    cart.setQuantity(1);
    listOfBooksInCart.add(cart);

    Cart cart1 = new Cart();
    cart1.setTitle("Html5");
    cart1.setAuthor("Messi");
    cart1.setBookId("067e6162-3b6f-2ae2-a171-2470b63dff00");
    cart1.setEdition("2ndEdition1");
    cart1.setISBN("22222222222222");
    cart1.setPrice(50.5);
    cart1.setImagePath("resources/images/html5.jpg");
    cart1.setPublisher("MUM university");
    listOfBooksInCart.add(cart1);

    return listOfBooksInCart;
}
    public static Book getClickedBook(String bookid) {
        List<Book> books = dataDao.getListOfBooks();
        for (Book book : books) {
            if (book.getBookId().equalsIgnoreCase(bookid)) {
                return book;
            }
        }
        return null;
    }
public static Book getOneBookFromFile(String bookId)
{
    List<Book> books=dataDao.getBooksFromFile();
    for(Book book:books)
    {
        if(book.getBookId().trim().equalsIgnoreCase(bookId.trim()))
        {
            return book;
        }
    }
    return null;
}

    public static boolean checkBookExistOrNot(String isbn)
    {
        List<Book> books=dataDao.getBooksFromFile();
        for(Book book:books)
        {
            if(book.getISBN().trim().equalsIgnoreCase(isbn.trim()))
            {
                return true;
            }
        }
        return false;
    }


    public static List<Book> saveMyBook(Book book) {
        List<Book> books = dataDao.getListOfBooks();
        for (Book b : books) {
            if (b.getISBN().equalsIgnoreCase(book.getISBN())) {
                b.setQuantity(b.getQuantity() + book.getQuantity());
            }
            books.add(book);
        }
        return books;
    }

//    public static List<Book> addToCart(Book book)
//    {
//      //  List<Book> listOfBooksInCart=dataDao.getListOfBooks();
//        for (Book b:listOfBooksInCart) {
//            if(b.getISBN().equalsIgnoreCase(book.getISBN()))
//            {
//                b.setQuantity(b.getQuantity()+book.getQuantity());
//            }
//            listOfBooksInCart.add(book);
//        }
//        return  listOfBooksInCart;
//    }


    private static Book getBookInCart(List<Book> bookInCarts, Book book) {
        if (book != null) {
            for (Book bookInCart : bookInCarts) {
                if (bookInCart.equals(book)) {
                    return bookInCart;
                }
            }
        }
        return null;
    }

    public static List<Book> aCart(Book book) {
        List<Book> booksInCarts = new ArrayList<>();
            dataDao d = new dataDao();
            d.saveCartToFile(book);
        return booksInCarts;
    }
    public static List<Book> aCartWithFileName(Book book,String fileName) {
        List<Book> booksInCarts = new ArrayList<>();
        dataDao d = new dataDao();
        d.saveCartToFileWithFileName(book,fileName);
        return booksInCarts;
    }

    //============================================
    public static boolean saveCartToFileWithFileName(Book book,String fileName)
    {
        try
        {
            Gson gson = new Gson();
            File file = new File("C:\\Users\\Mengistu\\IdeaProjects\\mumBookStore\\web\\resources\\dataFiles\\" + fileName);
            //        File file = new File("resources/dataFiles/cart.json");
            //        File file1 = new File("/resources/dataFiles/cart.json");
            String content = gson.toJson(book);

            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.newLine();
            bw.write(content);
            bw.close();

            return true;
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }
        return false;
    }
    //=========================================
    public static boolean makeCartEmpty()
    {
        try
        {
            File file = new File("C:\\Users\\Mengistu\\IdeaProjects\\mumBookStore\\web\\resources\\dataFiles\\cart.json");
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile(), false);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.newLine();
            bw.close();

            return true;
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }
        return false;
    }
    public static boolean saveCartToFile(Book book)
    {
        try
        {
           Gson gson = new Gson();
            File file = new File("C:\\Users\\Mengistu\\IdeaProjects\\mumBookStore\\web\\resources\\dataFiles\\cart.json");
    //        File file = new File("resources/dataFiles/cart.json");
    //        File file1 = new File("/resources/dataFiles/cart.json");
            String content = gson.toJson(book);

            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.newLine();
            bw.write(content);
            bw.close();

    return true;
    }

    catch (IOException e)
    {
        e.printStackTrace();
    }
    return false;
}
//Add Book
    public static boolean saveBookToFile(Book book)
    {
        try
        {
            Gson gson = new Gson();
            File file = new File("C:\\Users\\Mengistu\\IdeaProjects\\mumBookStore\\web\\resources\\dataFiles\\book.json");
            //        File file = new File("resources/dataFiles/cart.json");
            //        File file1 = new File("/resources/dataFiles/cart.json");
            String content = gson.toJson(book);

            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.newLine();
            bw.write(content);
            bw.close();

            return true;
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }
        return false;
    }
//Save it to cart
    public static List<Book> readFile()
    {
        File filePath = new File("C:\\Users\\Mengistu\\IdeaProjects\\mumBookStore\\web\\resources\\dataFiles\\cart.json");
        Gson gson = new Gson();
        List<String> records = new ArrayList<String>();
        List<Book> myBooks = new ArrayList<Book>();
        if (!filePath.exists()) {
           return null;
        }
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null)
            {
                if ((line.trim()!=null) || (line.trim()!=""))
                {
                    Book book = gson.fromJson(line, Book.class);
                    if(book!=null)
                    {
                        myBooks.add(book);
                    }

                    records.add(line);
                }

            }
            reader.close();
            return myBooks;
        }
        catch (Exception e)
        {
            System.err.format("Exception occurred trying to read '%s'.", filePath);
            e.printStackTrace();
            return null;
        }
    }
//Reading cart using session id
    public static List<Book> readCartFromFileWithFileName(String fileName)
    {
      //  InputStream resource = getServletContext().getResourceAsStream("/WEB-INF/");
     //   File filePath = new File(fileName);

       File filePath = new File("C:\\Users\\Mengistu\\IdeaProjects\\mumBookStore\\web\\resources\\dataFiles\\"+fileName);

        Gson gson = new Gson();
        List<String> records = new ArrayList<String>();
        List<Book> myBooks = new ArrayList<Book>();
        if (!filePath.exists()) {
            return null;
        }
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null)
            {
                if ((line.trim()!=null) || (line.trim()!=""))
                {
                    Book book = gson.fromJson(line, Book.class);
                    if(book!=null)
                    {
                        myBooks.add(book);
                    }

                    records.add(line);
                }

            }
            reader.close();
            return myBooks;
        }
        catch (Exception e)
        {
            System.err.format("Exception occurred trying to read '%s'.", filePath);
            e.printStackTrace();
            return null;
        }
    }

    //Read Books
    public static List<Book> getBooksFromFile()
    {
        File filePath = new File("C:\\Users\\Mengistu\\IdeaProjects\\mumBookStore\\web\\resources\\dataFiles\\book.json");
        Gson gson = new Gson();
        List<String> records = new ArrayList<String>();
        List<Book> myBooks = new ArrayList<Book>();
        try
        {
            if (!filePath.exists()) {
                return null;
            }
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null)
            {
                if (line.trim()!=null)
                {
                    if  (line.trim()!="") {
                        Book book = gson.fromJson(line, Book.class);
                        if (book != null) {
                            myBooks.add(book);
                        }
                    }

                    records.add(line);
                }

            }
            reader.close();
            return myBooks;
        }
        catch (Exception e)
        {
            System.err.format("Exception occurred trying to read '%s'.", filePath);
            e.printStackTrace();
            return null;
        }
    }



    public static List<User> userInfo()
    {
        List<User> listOfUsers=new ArrayList<User>();
        listOfUsers.add(new User("Mengistu","m"));
        listOfUsers.add(new User("Bereket","b"));
        return listOfUsers;
    }

    public static boolean isValid(User user)
    {
        List<User> users=dataDao.userInfo();
        for (User u:users) {
            if(u.getUserName().equalsIgnoreCase(user.getUserName()))
            {
                if(u.getPassword().equalsIgnoreCase(user.getPassword()))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean removeCart(String fileName)
    {

            File file = new File("C:\\Users\\Mengistu\\IdeaProjects\\mumBookStore\\web\\resources\\dataFiles\\" + fileName);

            if (!file.exists()) {
                file.delete();
                return true;
            }

        return false;
    }


//    public static List<Book> aCart(Book book) {
//        List<Book> booksInCarts = dataDao.getListOfBooks() != null ? dataDao.getListOfBooks() : new ArrayList<Book>();
//
//        Map<String, String> status = new HashMap<String, String>();
//        if (book != null) {
//            Book existingBookInCart = getBookInCart(booksInCarts, book);
//            if (existingBookInCart != null) {
//                status.put("status", "item exists");
//            } else {
//                status.put("status", "item added successfully");
//                booksInCarts.add(book);
//            }
//            dataDao d = new dataDao();
//            //  d.setBooksInCart(booksInCarts);
//
//            boolean b=d.saveCartToFile(book);
//        }
//        return booksInCarts;
//    }
//    public static boolean isValid(User1 user) {
//        List<User1> users = dataDao.userInfo();
//        for (User1 u : users) {
//            if (u.getUserName().equalsIgnoreCase(user.getUserName())) {
//                if (u.getPassword().equalsIgnoreCase(user.getPassword())) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }



//    public static List<User1> userInfo() {
//        List<User1> listOfUsers = new ArrayList<User1>();
//
//        User1 u = new User1();
//        u.setUserName("BAdmin");
//        u.setPassword("pass");
//        listOfUsers.add(u);
//        listOfUsers.add(u);
//        return listOfUsers;
//    }
}

