<%--
  Created by IntelliJ IDEA.
  User: Mengistu
  Date: 2/5/2018
  Time: 11:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

        <%--<link href="<c:url value='/resources/css/mumBookStore.css' />" rel="stylesheet">--%>
        <%--<link href="<c:url value='/resources/bootstrap/bootstrap-4.0.0-dist/css/bootstrap.css' />" rel="stylesheet">--%>
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
            <script type="text/javascript" src="resources/js/jquery-3.3.1.js"></script>
            <script type="text/javascript" src="resources/js/imageUpload.js"></script>

<style>
    #center {
        text-align: center;
        width: 60%;
    }
    label {
        font-size: medium;
    }
</style>
    <title>Title</title>
</head>
<body>
<%@ include file="header.jsp"%>
<div class="col-md-2"></div>
<div class="col-md-10">

<div id="center" class="">
    <form method="post" action="addBookServlet">
        <div class="form-group">
            <label for="title">Title</label>
            <input type="text" class="form-control" id="title"  name="title" placeholder="Title">
        </div>
        <div class="form-group">
            <label for="author">Author</label>
            <input type="text" class="form-control" id="author"   name="author" placeholder="Author">
        </div>
        <div class="form-group">
            <label for="edition">Edition</label>
            <input type="text" class="form-control" id="edition"   name="edition" placeholder="Edition">
        </div>
        <div class="form-group">
            <label for="isbn">ISBN</label>
            <input type="text" class="form-control" id="isbn"   name="isbn" placeholder="ISBN">
        </div>

        <div class="form-group">
            <label for="publisher">Publisher</label>
            <input type="text" class="form-control" id="publisher"   name="publisher" placeholder="Publisher">
        </div>
        <div class="form-group">
            <label for="price">Price</label>
            <input type="text" class="form-control" id="price"   name="price" placeholder="Price">
        </div>

        <button type="submit" class="btn btn-default"  id="addBook">Add Book</button>


    </form>
<fieldset>
    <form method="get" id="myFormId">
        <div class="form-group">
        <label for="file">File input</label>
        <input type="file" id="file" name="file">
            <button type="submit" class="btn btn-default"  id="btnUpload">Upload Image</button>
    </div>

    </form>
</fieldset>
</div>
</div>
<div class="col-md-2"></div>
<%@ include file="footer.jsp"%>
</body>
</html>
