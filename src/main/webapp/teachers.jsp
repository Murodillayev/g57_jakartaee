<%--
  Created by IntelliJ IDEA.
  User: macbookpro
  Date: 24/11/25
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
    <title>Title</title>
</head>
<body>

<table class="table">
    <thead>
    <tr>
        <th>id</th>
        <th>full name</th>
        <th>salary</th>
        <th>level</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach var="teacher" items="${teachers}">
        <tr>
            <td>${teacher.id}</td>
            <td>${teacher.fullName}
            </td>
            <td>${teacher.salary}
            </td>
            <td>${teacher.level}
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>


</body>
</html>
