<%-- 
    Document   : main
    Created on : 18/04/2018, 17:47:50
    Author     : alexandre.yoshimura
--%>
<%@ page session="true" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <br>
        ${sessionScope.sUsuario}
    </body>
</html>
