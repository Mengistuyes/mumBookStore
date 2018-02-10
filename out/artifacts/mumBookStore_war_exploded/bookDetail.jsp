<%@ page import="com.mum.model.Book" %><%--
  Created by IntelliJ IDEA.
  User1: Mengistu
  Date: 2/5/2018
  Time: 3:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value='/resources/css/mumBookStore.css' />" rel="stylesheet">
    <link href="<c:url value='/resources/bootstrap/bootstrap-4.0.0-dist/css/bootstrap.css' />" rel="stylesheet">
    <script type="text/javascript" src="resources/js/jquery-3.3.1.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script type="text/javascript" src="resources/js/addToCart.js"></script>

    <title>Mum Online Book Store</title>
<style>

    #makeItCenter
    {
        /*text-align: center;*/
    }
</style>
</head>
<body>
<%@ include file="header.jsp"%>
<div id="makeItCenter">
<div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-8 jumbotron">
        <div class="row">
               <div class="col-md-5"><img src="${myBook.getImagePath()}" alt="${myBook.getTitle()}" id="imagePath" width="250px" height="350px"/></div>
               <div class="col-md-5"> ISBN:-    <p id="isbn">${myBook.getISBN()}</p>
                Title:-  <p id="title">${myBook.getTitle()}</p>
                Author:-   <p id="author">${myBook.getAuthor()}</p>
                Publisher:- <p id="publisher">${myBook.getPublisher()}</p>
                Price:-  <p id="price">${myBook.getPrice()}</p>
                Edition:-  <p id="edition">${myBook.getEdition()}</p></div>
            <div class="col-md-2"> <button class="btn btn-success btn-lg add" id="addToCart">Add to Cart</button></div>
        </div>

    </div>
</div>
</div>
<%@ include file="footer.jsp"%>
</body>
</html>
