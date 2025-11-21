<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Todos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">

</head>
<body style="padding: 100px">


<form action="/todo" method="post">
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="id" value="${todo.id}">
    <input type="text" name="title" value="${todo.title}">
    <input type="text" name="description" value="${todo.description}">
    <button type="submit">Save</button>
</form>
</body>
</html>
