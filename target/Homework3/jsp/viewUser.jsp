<%--
  Created by IntelliJ IDEA.
  User: ADMINS
  Date: 2020/06/02
  Time: 23:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User information</title>
</head>
<body>
<h2>User information</h2>
<form method="POST" action="./UpdateUserServlet">
    <table border="0">
        <tr>
            <td>User Name</td>
            <td><input type="text" name="username" value="${username}"/></td>
        </tr>
        <tr>
            <td>Current password</td>
            <td><input type="password" name="password" value="${password}"/></td>
        </tr>
        <tr>
            <td>New password</td>
            <td><input type="password" name="newPassword" value="${newPassword}"/></td>
        </tr>
        <tr>
            <td>Confirm new password</td>
            <td><input type="password" name="confirmNewPassword" value="${confirmNewPassword}"/></td>
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
            <td></td>
            <td>
                <a href="GoUserFunctionServlet">Back</a>
                <input type="submit" value="Save"/>
            </td>
        </tr>
    </table>
</form>

<c:forEach var="error" items="${errorMessage}">
    <div style="color: red">
            ${error}
    </div>
</c:forEach>

<h2>${updateMessage}
</h2>

</body>
</html>