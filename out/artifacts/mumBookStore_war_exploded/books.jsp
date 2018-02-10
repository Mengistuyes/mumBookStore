<%--
  Created by IntelliJ IDEA.
  User: Mengistu
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
    <script type="text/javascript" src="resources/js/book.js"></script>
    <title>Mum Online Book Store</title>
</head>
<body>
<%@ include file="header.jsp"%>
<div class="container">
<div class="row" >

<c:forEach items="${books}" var="book" varStatus="counter">
<div class="col-md-3">
        <a href=<c:url value="/bookDetailServlet" var="myurl">
                                     <c:param name="q" value="${book.getBookId()}" />
        </c:url>>

           <div id="imgp"> <p><img src="${book.getImagePath()}" alt="${book.getTitle()}" width="140px" height="140px" /></p></div></a>

                 <p style="text-align: left">Title:- ${book.getTitle()}<br>
                    Author:- ${book.getAuthor()}<br>
                    Price:- ${book.getPrice()}</p>
                    <c:url value="/bookDetailServlet/${book.getBookId()}" var="bookIdPlusUrl" />
                    <button class="btn btn-success" style="align-self: center"
                    onclick="location.href='${myurl}'">View Detail</button>

                <%--&lt;%&ndash;<p>ISBN:- </p>${book.getISBN()}&ndash;%&gt;--%>
                <%--<p style="text-align: center">Title:- ${book.getTitle()}</p>--%>
                <%--<p style="text-align: center">Author:- ${book.getAuthor()}</p>--%>
                <%--&lt;%&ndash;<p>Publisher:- </p>${book.getPublisher()}&ndash;%&gt;--%>
                <%--<p style="text-align: center">Price:- ${book.getPrice()}</p>--%>
                <%--&lt;%&ndash;<p>Edition:- </p>${book.getEdition()}&ndash;%&gt;--%>
            <%--<c:url value="/bookDetailServlet/${book.getBookId()}" var="bookIdPlusUrl" />--%>
            <%--<button class="btn btn-success"--%>
                 <%--onclick="location.href='${myurl}'">View Detail</button>--%>
</div>
</c:forEach><br>
</div>
</div>
<%@ include file="footer.jsp"%>
</body>

</html>
