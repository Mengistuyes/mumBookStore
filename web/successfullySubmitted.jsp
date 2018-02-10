<%--
  Created by IntelliJ IDEA.
  User: Mengistu
  Date: 2/8/2018
  Time: 12:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>

        h1 {
            color: green;
            font-weight: bold;
        }
    </style>
    <title>Successfully Submited</title>
</head>
<body>
<%@ include file="header.jsp"%>
<div><h1>Successfully Submitted</h1>

    <h2>Your item will be shipped on Monday</h2>
</div>
<% request.getRequestDispatcher("/com.mum/controller/bookListServlet").forward(request,response);%>
<%@ include file="footer.jsp"%>
</body>
</html>
