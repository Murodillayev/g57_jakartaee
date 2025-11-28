<%--
  Created by IntelliJ IDEA.
  User: macbookpro
  Date: 24/11/25
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
    <title>Title</title>
</head>
<body>

<%if (request.getParameter("error") != null) {%>
    <h1><%=request.getParameter("error")%></h1>
<%}%>

<table class="table">
    <thead>
    <tr>
        <th>id</th>
        <th>full name</th>
        <th>grade</th>
        <th>course</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach var="student" items="${students}">
        <tr>
            <td>${student.id}</td>
            <td>${student.fullName}
            </td>
            <td>${student.grade}
            </td>
            <td>${student.courseNumber}
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
