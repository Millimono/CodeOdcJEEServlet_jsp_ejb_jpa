<%-- 
    Document   : BookServlet
    Created on : 6 juin 2024, 16 h 58 min 22 s
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <h1>Payment Confirmation</h1>
       <p>User ${sessionScope.username} has 
           successfully paid for the book: ${sessionScope.Livre.numLivre}</p>
   </body>

</html>
