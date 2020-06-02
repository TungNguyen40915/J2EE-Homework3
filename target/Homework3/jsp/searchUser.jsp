<%--
  Created by IntelliJ IDEA.
  User: batung
  Date: 6/2/20
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Search User</title>
</head>
<body>

<h1>Search User</h1>
<a href="GoAdminFunctionServlet">Main menu</a>
<br/>
<a href="LogoutServlet">Logout</a>
<br/>

<form method="POST" action="./SearchUserServlet">
    <table border="1">
        <tr>
            <td>User name <input type="text" name="userName" value="${userName}"/></td>
            <td>
                Role
                <select name="role" id="role">
                    <option value=""></option>
                    <option value="1">Admin</option>
                    <option value="2">User</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>First Name <input type="text" name="firstname" value="${firstname}"/></td>
            <td>Last Name <input type="text" name="lastname" value="${lastname}"/></td>
        </tr>
        <tr>
            <td>Sex <input type="text" name="sex" value="${sex}"/></td>
            <td>Email <input type="text" name="email" value="${email}"/></td>
        </tr>
        <tr>
            <td>Address <input type="text" name="address" value="${address}"/></td>
            <td>Mobile Phone <input type="text" name="mobilephone" value="${mobilephone}"/></td>
            <td><input type="submit" value="search"/></td>
        </tr>
    </table>
</form>

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
        </tr>
    </c:forEach>
</table>
</body>
</html>
