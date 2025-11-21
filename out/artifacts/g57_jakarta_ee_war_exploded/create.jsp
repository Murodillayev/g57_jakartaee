<%@ page import="uz.pdp.g57jakarta_ee.model.Todo" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
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
    <input type="text" name="title">
    <input type="hidden" name="action" value="create">
    <input type="text" name="description">
    <button type="submit">Save</button>
</form>
</body>
</html>




