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
    <title>Create New User</title>
</head>
<body>
<h1>Create New User</h1>
<a href="GoAdminFunctionServlet">Main menu</a>
<br/>
<a href="LoginServlet">Logout</a>
<br/>

<form method="POST" action="./GoCreateUserServlet">
    <table border="0">
        <tr>
            <td>User Name</td>
            <td><input type="text" name="userName" value="${username}"/></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password" value="${password}"/></td>
        </tr>
        <tr>
            <td>Confirm Password</td>
            <td><input type="password" name="confirmPassword" value="${confirmPassword}"/></td>
        </tr>
        <tr>
            <td>First Name</td>
            <td><input type="text" name="firstname" value="${firstname}"/></td>
        </tr>
        <tr>
            <td>Last Name</td>
            <td><input type="text" name="lastname" value="${lastname}"/></td>
        </tr>
        <tr>
            <td>Sex</td>
            <td><input type="text" name="sex" value="${sex}"/></td>
        </tr>
        <tr>
            <td>Address</td>
            <td><input type="text" name="address" value="${address}"/></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="text" name="email" value="${email}"/></td>
        </tr>
        <tr>
            <td>Mobile Phone</td>
            <td><input type="text" name="mobilephone" value="${mobilephone}"/></td>
        </tr>

        <tr>
            <td colspan="2">
                <input type="submit" value="save"/>
            </td>
        </tr>
    </table>
</form>


<c:forEach var="error" items="${errorMessage}">
    <div style="color: red">
        ${error}
    </div>
</c:forEach>
<h2>${insertMessage}
</h2>


</body>
</html>
