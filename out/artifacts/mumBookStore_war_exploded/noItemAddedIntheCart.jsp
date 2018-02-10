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
</head>
<body>
<%@ include file="header.jsp"%>
<div class="container">
    <table id="myTable" class=" table order-list">
        <thead>
        <tr>
            <td></td>
            <td>Title</td>
            <td>ISBN</td>
            <td>Author</td>
            <td>Price</td>
        </tr>
        </thead>
        <tbody>
        <h1 style="color: red">No item added!</h1>
       </tr>
        </tbody>
        <tfoot>
        <tr>
            <td colspan="5" style="text-align: right;">
                <p id="totalPrice">Total: ${total}</p>
            </td>
        </tr>
        <tr>
        </tr>
        </tfoot>
    </table>
</div>
<%@ include file="footer.jsp"%>
</body>
</html>
