<%--
  Created by IntelliJ IDEA.
  User: batung
  Date: 5/31/20
  Time: 00:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
    <h3>Login Page</h3>
    <form method="POST" action="./LoginServlet">
        <table border="0">
            <tr>
                <td>User Name</td>
                <td><input type="text" name="userName" value= "userName" /> </td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password" value= "password" /> </td>
            </tr>

            <tr>
                <td colspan ="2">
                    <input type="submit" value= "Submit" />
                </td>
            </tr>
        </table>
        <%= request.getAttribute("errorMessage") %>
    </form>
</head>
<body>

</body>
</html>

