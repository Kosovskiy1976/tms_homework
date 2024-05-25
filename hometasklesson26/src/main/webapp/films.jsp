
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Bank</title>
</head>
<body>
    Add new Film<br>
<form method="post" action="/home">
    <input type="text" name="name"><br>
    <input type="text" name="description"><br>
    <input type="number" name="yearOfRelease"><br>
    <input type="text" name="viewed"><br>
    <input type="submit" value="save">
</form>

<hr>
<ul>
    <c:forEach items="${films}" var="film">
        <li>
            ${film.name}
        </li>
    </c:forEach>
</ul>
</body>
</html>