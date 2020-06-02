<%--
  Created by IntelliJ IDEA.
  User: batung
  Date: 6/2/20
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List Users</title>
</head>
<body>
<h1>List Users</h1>
<a href="GoAdminFunctionServlet">Main menu</a>
<br/>
<a href="LogoutServlet">Logout</a>
<br/>


<form method="POST" action="./ListUserServlet">
    <table border="1">
        <tr>
            <td>User Name</td>
            <td>First Name</td>
            <td>Last Name</td>
            <td>Sex</td>
            <td>Address</td>
            <td>Email</td>
            <td>Mobile Phone</td>
        </tr>

        <c:forEach var="user" items="${list}">
            <tr>
                <td>${user.username}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.sex}</td>
                <td>${user.address}</td>
                <td>${user.email}</td>
                <td>${user.mobilePhone}</td>
                <td><input type="checkbox" name="selected" value="${user.username}"> </td>
            </tr>
        </c:forEach>
    </table>
    <input type="submit" name="back" value="back"/>
    <input type="submit" name="create" value="create"/>
    <input type="submit" name="delete" value="delete"/>
</form>





</body>
</html>
