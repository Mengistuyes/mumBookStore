<%--
  Created by IntelliJ IDEA.
  User: Mengistu
  Date: 2/6/2018
  Time: 12:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%--<link href="<c:url value='resources/bootstrap/bootstrap-4.0.0-dist/css/bootstrap.css'/>" rel="stylesheet">--%>
    <%--<link href="<c:url value='resources/bootstrap/bootstrap-4.0.0-dist/css/bootstrap-grid.css'/>" rel="stylesheet">--%>
    <%--<link href="<c:url value='resources/bootstrap/bootstrap-4.0.0-dist/css/bootstrap-reboot.css'/>" rel="stylesheet">--%>

    <%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">--%>
    <%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js">--%>
    <%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js">--%>
        <%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>--%>

    <%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>--%>
    <%--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="resources/js/cartButtonClickCount.js"></script>
    <title>Title</title>
    <style>
        h1{
            text-align: center;
            vertical-align: center;
        }
        #height {
            height: 150px;
            width: 100%;
        }
        a {
            text-align: right;
        }

        .mumLogo {
            height: 50px;
            width: 50px;
        }
        p {
            font-family: SansSerif;
            font-size: medium;
        }
        .btn {
            font-family: SansSerif;
            font-size: large;
            color: white;
        }
        #itemCount {
            position: absolute;
            display: none;
            top: -10px;
            left: -10px;
            width: 20px;
            height: 20px;
            border-radius: 50%;
            background: green;
            color: white;
            text-align: center;
        }

        #itemCount1 {
            position: absolute;
            display: none;
            border-radius: 50%;
            background: green;
            color: white;
            text-align: center;
        }

        #cart-container {
            float: right;
            width: 210px;
            position: relative;
        }
    </style>
</head>
<body>
<div class="row">
</div>
<div id="height" class="row">
    <div class="row"></div>
    <c:url value="/" var="myurl" />
    <div class="col-md-2 mumLogo"><img src="<c:url value="/resources/images/Logo.jpg"></c:url>" alt="logo" height="100px" width="100px"/></div>
    <div class="col-md-2"><a href='${myurl}' class="btn btn-info btn-lg">
        <span class="glyphicon glyphicon-home"></span> Home
    </a></div>
    <div class="col-md-4"><h1>MUM Online Book Store</h1></div>
    <div class="col-md-4">

        <%----%>
        <p><a href="addBook.jsp">Add Book</a>

            <a href="login.jsp" class="btn btn-info btn-lg">
                <span class="glyphicon glyphicon-log-in"></span> Log in
            </a>

            <a href="com.mum/controller/bookListServlet" class="btn btn-info btn-lg">
                <span class="glyphicon glyphicon-log-out"></span> Log out
            </a>
        </p>
        <div id="cart-container">
            <div id="cart">
                <a href="shoppingCartServlet"> <span id="itemCount"></span><i class="fa fa-shopping-cart fa-3x" aria-hidden="true"></i>
                <span class="badge badge-light" id="itemCount1"></span></a>
            </div>
        </div>

        <%----%>
        <%--<a href="shoppingCartServlet" class="btn btn-info btn-sm">--%>
            <%--<span class="glyphicon glyphicon-shopping-cart"></span> Shopping Cart--%>
            <%--<span class="badge badge-light"></span>--%>
        <%--</a>--%>
            <%--<div id="cart-container">--%>
                <%--<div id="cart">--%>
                    <%--<span id="itemCount"></span><i class="fa fa-shopping-cart fa-3x" aria-hidden="true"></i>--%>
                <%--</div>--%>

            <%--</div>--%>
          <%--<a href="shoppingCartServlet"><p id="#itemCount"></p> <i class="fa fa-shopping-cart" style="font-size:48px;color:red"></i></a>--%>

            <%--<button type="button" class="btn btn-primary">--%>
            <%--<a href="addBook.jsp">Add Book</a>--%>
        <%--</button>--%>

        <%--<button type="button" class="btn btn-success"> <a href="login.jsp">Login</a></button>--%>

        <%--<button type="button" class="btn btn-info"><a href="bookListServlet">Logout</a></button>--%>

    </div>

</div>

<%--<div><i class="fa fa-shopping-Cart" style="font-size:48px;color:black"> </i></div>--%>
</body>
</html>
