<%@ page import="bean.UsersEntity" %>
<%@ page import="java.util.List" %>
<%@page pageEncoding="utf-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>ListAllUsers</title>
</head>
<body>
<table border="1" cellspacing="10">

    <tr>
        <th>UserID</th>
        <th>UserName</th>
        <th>UserPassword</th>
        <th>Email</th>
        <th>MAC</th>
    </tr>
    <%
        for (UsersEntity usersEntity : (List<UsersEntity>) request.getAttribute("users")) {
    %>
    <tr>
        <td><%out.print(usersEntity.getUid());%></td>
        <td><%out.print(usersEntity.getUname());%></td>
        <td><%out.print(usersEntity.getUpass());%></td>
        <td><%out.print(usersEntity.getEmail());%></td>
        <td><%out.print(usersEntity.getMac());%></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
