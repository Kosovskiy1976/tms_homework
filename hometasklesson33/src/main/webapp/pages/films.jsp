<%@taglib prefix="sp" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="mes" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Bank</title>
</head>
<body>
<a href="home?lang=en">En</a><br>
<a href="home?lang=ru">Ru</a><br>
<br><hr>
<mes:message code="title"/>
<br><hr>
<sp:form method="post" action="/home" modelAttribute="filmmodel">
    <mes:message code="Name"/>    <sp:input path="name" type="text" name="name"/><br><br>
    <mes:message code="Description"/> <sp:input path="description" type="text" name="description"/><sp:errors path="description" /> <br><br>
    <mes:message code="yearOfRelease"/> <sp:input path="yearOfRelease" type="number" name="yearOfRelease"/><sp:errors path="yearOfRelease" /><br><br>
    <mes:message code="viewed"/> <sp:input path="viewed" type="text" name="viewed"/><br><br>
    <input type="submit" value="save">
</sp:form>

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