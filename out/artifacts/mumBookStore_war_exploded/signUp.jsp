<%--
  Created by IntelliJ IDEA.
  User: bereket
  Date: 2/7/2018
  Time: 5:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Sign Up Form</title>
    <link href="<c:url value='/resources/css/signup.css' />" rel="stylesheet">
    <script type="text/javascript" src="resources/js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="resources/js/eventss.js"></script>
</head>
<body>
<%@ include file="header.jsp"%>
<div class="centering">
<form action="SignUpServlet" method="post" class="signup">
    <fieldset id="fiel" >
        <legend>Registration/Sign up Form </legend>
    <input type="text" name="firstname" id="firstname" value=""/>:<label>First Name</label><br/>
    <input type="text" name="lastname"  id="lastname" value=""/>:<label>Last Name</label><br/>
    <input type="text" name="name"  id="uname" value=""/>:<label>User Name</label> <br/>
    <input type="text" name="email"  id="email" value=""/>:<label>Email Add </label> <br/>
    <input type="password" name="pass" id="pass" value=""/>: <label>Password</label><br/>
    <input type="password" name="cpass" id="cpass" value=""/>: <label>Confirm Pass </label> <br/>
     <input type="submit" value="register" id="register" value="" />
    </fieldset>
</form>
</div>
<%@ include file="footer.jsp"%>
</body>
</html>

