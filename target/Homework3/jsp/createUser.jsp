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
            <td><input type="text" name="userName" value='<%=request.getAttribute("userName")%>'/></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password" value='<%=request.getAttribute("password")%>'/></td>
        </tr>
        <tr>
            <td>Confirm Password</td>
            <td><input type="password" name="confirmPassword" value='<%=request.getAttribute("confirmPassword")%>'/></td>
        </tr>
        <tr>
            <td>First Name</td>
            <td><input type="text" name="firstname" value='<%=request.getAttribute("firstname")%>'/></td>
        </tr>
        <tr>
            <td>Last Name</td>
            <td><input type="text" name="firstname" value='<%=request.getAttribute("firstname")%>'/></td>
        </tr>
        <tr>
            <td>Sex</td>
            <td><input type="text" name="sex" value='<%=request.getAttribute("sex")%>'/></td>
        </tr>
        <tr>
            <td>Address</td>
            <td><input type="text" name="address" value='<%=request.getAttribute("address")%>'/></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="text" name="email" value='<%=request.getAttribute("email")%>'/></td>
        </tr>
        <tr>
            <td>Mobile Phone</td>
            <td><input type="text" name="mobilephone" value='<%=request.getAttribute("mobilephone")%>'/></td>
        </tr>

        <tr>
            <td colspan="2">
                <input type="submit" value="save"/>
            </td>
        </tr>
    </table>
</form>

<div style="color: red"><%=request.getAttribute("errorMessage")%></div>
<h2><%=request.getAttribute("insertMessage")%>
</h2>


</body>
</html>
