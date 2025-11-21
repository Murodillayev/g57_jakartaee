<%@ page import="uz.pdp.g57jakarta_ee.model.Todo" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Todos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">

</head>
<body style="padding: 100px">

<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" aria-disabled="true">Disabled</a>
                </li>
            </ul>
            <form class="d-flex" role="search" action="/logout">
                <button class="btn btn-outline-danger" type="submit">Logout</button>
            </form>
        </div>
    </div>
</nav>
<table class="table">
    <thead>
    <tr>
        <th>id</th>
        <th>title</th>
        <th>description</th>
        <th>completed</th>
        <th>actions</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach var="todo" items="${todos}">
        <tr>
            <td>${todo.id}</td>
            <td>${todo.title}
            </td>
            <td>${todo.description}
            </td>
            <td>${todo.completed}
            </td>
            <td>
                <form action="/todo">
                    <input type="hidden" name="action" value="update">
                    <input type="hidden" name="id" value="${todo.id}">
                    <button class="btn btn-primary">Edit</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<form action="/create.jsp" method="get">
    <input type="hidden" name="action" value="create_page">
    <button class="btn btn-primary">Add todo</button>
</form>


</body>
</html>
