<%@ page import="com.mum.controller.loginServlet1" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <%--<link href="<c:url value='/resources/css/signup.css' />" rel="stylesheet">--%>
    <link href="<c:url value='/resources/css/login.css' />" rel="stylesheet">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Login</title>
</head>
<body>
<%@ include file="header.jsp"%>
<%
    Cookie[] cookies=request.getCookies();
    String userName = "", password = "",rememberVal="";
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("cookuser")) {
                userName = cookie.getValue();
            }
            if(cookie.getName().equals("cookpass")){
                password = cookie.getValue();
            }
            if(cookie.getName().equals("cookrem")){
                rememberVal = cookie.getValue();
            }
        }
    }
%>

<fieldset style="width: 600px; margin: auto;" >
    <legend id="legen">Login Form</legend>
    <div>
        <%=request.getAttribute("msg") != null ? request.getAttribute("msg") : ""%>


        <form  method="post"
               action="loginServlet" id="overit" class="form">
            <div class="imgcontainer">
                <img src="avatar.png" alt="Avatar" class="avatar">
            </div>

            <div class="container">

                <label for="userName"><b>Username</b></label>
                <input type="text" placeholder="Enter Username" name="username" value="<%=userName%>" required>

                <label for="password"><b>Password</b></label>
                <input type="password" placeholder="Enter Password" name="password" value="<%=password%>" required>

                <button type="submit">Login</button>
                <label>
                    <input type="checkbox" name="remember" checked="checked"
                           value="1"
                            <%= "1".equals(rememberVal.trim()) ? "checked" : "" %> />Remember me
                </label>
            </div>

            <div class="container" style="background-color:#f1f1f1">
                <button type="button" class="cancelbtn">Cancel</button>
                <span class="psw">Forgot <a href="#">password?</a></span>
            </div>
        </form>
        <%--<form  method="post"--%>
              <%--action="loginServlet" id="overit" class="form">--%>
            <%--<p>--%>
                <%--<label>Username :</label> <input type="text" name="username"--%>
                                               <%--autocomplete="off" value="<%=userName%>" />--%>
            <%--</p>--%>
            <%--<p>--%>
                <%--<label>Password :</label> <input type="password" name="password"--%>
                                               <%--autocomplete="off" value="<%=password%>" />--%>
            <%--</p>--%>
            <%--<p>--%>
                <%--<label>Remember</label> <input type="checkbox" name="remember"--%>
                                               <%--value="1"--%>
                    <%--<%= "1".equals(rememberVal.trim()) ? "checked" : "" %> />--%>
            <%--</p>--%>
            <%--<p>--%>
                <%--<input type="submit" name="login" value="Login" />--%>
            <%--</p>--%>
        <%--</form>--%>

    </div>
</fieldset>
<%@ include file="footer.jsp"%>
</body>
</body>
</html>

