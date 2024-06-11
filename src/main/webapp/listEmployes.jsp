<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>List of Employees</title>
</head>
<body>
    <h1>List of Employees</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Department</th>
            <th>Email</th>
            <th>Type</th>
            <th>Address</th>
        </tr>
        <c:forEach var="employe" items="${employes}">
            <tr>
                <td>${employe.id}</td>
                <td>${employe.nom}</td>
                <td>${employe.departement}</td>
                <td>${employe.email}</td>
                <td>${employe.employeeType}</td>
                <td>
                    ${employe.address}
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
