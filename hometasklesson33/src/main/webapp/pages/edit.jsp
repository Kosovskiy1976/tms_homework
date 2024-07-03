<%--
  Created by IntelliJ IDEA.
  User: user123
  Date: 26.05.2024
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<form method="post" action="/edit">
    <input type="hidden" name="id" value="${film.id}">
    Name:<input type="text" name="name" value="${film.name}"><br><br>
    Description:<input type="text" name="description" value="${film.description}"><br><br>
    yearOfRelease:<input type="number" name="yearOfRelease" value="${film.yearOfRelease}"><br><br>
    viewed:<input type="text" name="viewed" value="${film.viewed}"><br><br>
    <input type="submit" value="update">
</form>
</body>
</html>
