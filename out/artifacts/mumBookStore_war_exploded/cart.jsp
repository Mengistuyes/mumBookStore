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

    <title>Mum Online Book Store</title>
</head>
<body>
<%@ include file="header.jsp"%>
<div class="container-fluid">
    <div class="row">

        <c:forEach items="${booksInCart}" var="book" varStatus="counter">
            <div class="col-md-2"><a href=<c:url value="/bookDetailServlet">
                                         <c:param name="q" value="${book.getBookId()}" />
            </c:url>>
                <img src="${book.getImagePath()}" alt="${book.getTitle()}" width="200px" height="200px"/></a></div><br>
            <div class="col-md-2">


                    ${book.getISBN()}
                    ${book.getTitle()}
                    ${book.getAuthor()}
                    ${book.getPublisher()}
                    ${book.getPrice()}
                    ${book.getEdition()}

                    <%--<a href=<c:url value="/bookDetailServlet">--%>
                    <%--<c:param name="q" value="${book.getBookId()}" />--%>
                    <%--</c:url>>go</a>--%>

                <c:url value="/bookDetailServlet/${book.getBookId()}" var="bookIdPlusUrl" />
                <button class="btn btn-success"
                        onclick="location.href='${bookIdPlusUrl}'">Add to Cart</button>

                    <%--<c:url value="/bookDetailServlet/${book.getBookId()}" var="bookIdPlusUrl" />--%>
                    <%--<button class="btn btn-success"--%>
                    <%--onclick="location.href='${bookIdPlusUrl}'">Add to Cart</button>--%>


            </div>
        </c:forEach>
    </div>
</div>
<%@ include file="footer.jsp"%>
</body>

</html>
