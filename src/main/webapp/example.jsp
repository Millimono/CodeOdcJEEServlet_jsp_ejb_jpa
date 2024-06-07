<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date, com.mycompany.firstappcore.Personne" %>
<!DOCTYPE html>
<html>
<head>
    <title>Example JSP Page</title>
</head>
<body>
    <h1>Example JSP Page</h1>
    
    <h2>Using implicit variables</h2>
    <p>Request Parameter 'name': <%= request.getParameter("name") %></p>
    
    <%
        // Set a session attribute
        session.setAttribute("lastAccessTime", new Date());
        Personne sory = new Personne("sory","millimono");
    %>
    <p>Last Access Time (from session): 
        <%= session.getAttribute("lastAccessTime") %></p>
    
    <%
        // Using the application context to get an initialization parameter
        String appName = application.getInitParameter("appName");
    %>
    <p>Application Name: <%= appName %></p>
    
    <p>Current Date and Time: <%= new Date() %></p>
    
    <%
        // Including another JSP
        pageContext.include("footer.jsp");
    %>
</body>
</html>
