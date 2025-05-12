<%-- 
    Document   : index
    Created on : May 6, 2025, 9:29:17 PM
    Author     : Admin
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <!--
            EL: Expression Language: ${ten_bien}
            JSTL: Java Servlet tag library
        -->
        
        <%
            ArrayList<String> userList = new ArrayList<>();
            userList.add("Duck");
            userList.add("Lawrence");
            userList.add("Hehe");

            request.setAttribute("list_user", userList);
        %>
        
        <h1>Login</h1>
        <form action="process" method="POST">
            <input type="text" name="username" /> <br/>
            <input type="text" name="password" /> <br/>
            <input type="submit" value="LOGIN" />
        </form> 
        
        ${requestScope.message_error}
        
        <c:if test="${message_error == null}">
            <h1>Hello world</h1>
        </c:if>
        
        <c:forEach var="tay" items="${requestScope.list_user}">
            <h1> ${tay} </h1>
        </c:forEach>
            
            
    </body>
</html>
