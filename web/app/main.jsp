<%-- 
    Document   : main
    Created on : 18/04/2018, 17:47:50
    Author     : alexandre.yoshimura
--%>
<%@ page session="true" %>
<%@ page import="java.util.Random" %>
<%
Random rand = new Random();
int n = rand.nextInt(90000) + 10000;
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../plugins/DataTable/jquery.dataTables.min.css" rel="stylesheet">
        <link href="../plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <h1>Hello World!</h1><small>${sessionScope.sUsuario}</small>
        <br>
        
        
        <a href="templates/config/produtor/cadastroProdutor.jsp">Cadastrar Produtor</a>
    </body>
    
    <script src="../plugins/bootstrap/js/jquery-1.10.2.js"></script>
    <script src="../plugins/DataTable/jquery.dataTables.min.js"></script>
    <script src="../plugins/bootstrap/js/bootstrap.min.js"></script>
</html>
