
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Bank</title>
</head>
<body>
Add new Film<br>
<form method="post" action="/home">
    Name:<input type="text" name="name"><br><br>
    Description:<input type="text" name="description"><br><br>
    yearOfRelease:<input type="number" name="yearOfRelease"><br><br>
    viewed:<input type="text" name="viewed"><br><br>
    <input type="submit" value="save">
</form>

<hr>
<ul>
    <c:forEach items="${films}" var="film">
        <li>
                ${film.name}
            -----<a href="<c:url value='/edit?id=${film.id}'/>"> Edit </a>
            -----<a href="<c:url value='/del?id=${film.id}'/>"> Delete </a>
        </li>
    </c:forEach>
</ul>
</body>
</html>