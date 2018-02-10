<%--
  Created by IntelliJ IDEA.
  User: Mengistu
  Date: 2/7/2018
  Time: 11:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Shopping Cart</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script type="text/javascript" src="resources/js/cart.js"></script>
    <style>
        .myDivWidth {
            width: 80%;
        }

    </style>
</head>
<body>
<%@ include file="header.jsp"%>
<div class="container ">
    <div class="col-md-1"></div>
    <div class="col-md-10">
    <table id="myTable" class=" table order-list myDivWidth">
        <thead>
        <tr>
            <td></td>
            <td>Title</td>
            <td>ISBN</td>
            <td>Author</td>
            <td>Price</td>
            <%--<td>Quantity</td>--%>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${BooksInCart}" var="book" varStatus="counter">
        <tr >
            <td class="col-sm-2">
                <%--<img src="${book.getImagePath()}" alt="${book.getTitle()}" width="100px" height="100px"/>--%>
                <p> <img src="<c:url value="${book.getImagePath()}"></c:url>" alt="${book.getTitle()}" height="100px" width="100px"/></td></p>
            </td>
            <td class="col-sm-2">
                <p id="title">${book.getTitle()}</p>
            </td>
            <td class="col-sm-2">
                <p id="isbn"> ${book.getISBN()}</p>
            </td>
            <td class="col-sm-2">
                <p id="author">${book.getAuthor()}</p>
            </td>

            <td class="col-sm-2">
                <p id="price"> ${book.getPrice()}</p>
            </td>
            <%--<td class="col-sm-1">--%>
                <%--<input type="text" name="quantity" class="form-control" />--%>
            <%--</td>--%>
            <td class="col-sm-2"><a class="deleteRow"></a>
                <td><input type="button" class="ibtnDel btn btn-md btn-danger "  value="Delete"></td>
            </td>
            </c:forEach> </tr>
        </tbody>
        <tfoot>
        <tr>
            <td colspan="5" style="text-align: right;">
                <p id="totalPrice">Total: ${total}</p>
            </td>
            <td  style="text-align: right;">
               <a href="personalInfoServlet"> <input type="button" id="checkout" class="btn btn-md btn-success " value="Checkout"></a>
            </td>
        </tr>
        <tr>
        </tr>
        </tfoot>
    </table>
    </div>
    <div class="col-md-1"></div>
</div>
<%@ include file="footer.jsp"%>
</body>
</html>
