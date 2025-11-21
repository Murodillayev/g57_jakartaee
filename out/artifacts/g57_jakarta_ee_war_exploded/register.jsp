<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body style="padding: 200px;">

<form action="/register" method="post" enctype="multipart/form-data">
    <div class="mb-3">
        <label for="1" class="form-label">Full name</label>
        <input type="text" class="form-control" id="1" name="fullName">
    </div>
    <div class="mb-3">
        <label for="2" class="form-label">Username</label>
        <input type="password" class="form-control" id="2" name="username">
    </div>

    <div class="mb-3">
        <label for="file" class="form-label">Image</label>
        <input type="file" class="form-control" id="file" name="image">
    </div>
    <div class="mb-3">
        <label for="exampleInputPassword1" class="form-label">Password</label>
        <input type="password" class="form-control" id="exampleInputPassword1" name="password">
    </div>
    <button type="submit" class="btn btn-primary">Register</button>
</form>

</body>
</html>
