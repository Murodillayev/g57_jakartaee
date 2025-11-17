<%--
  Created by IntelliJ IDEA.
  User: macbookpro
  Date: 14/11/25
  Time: 18:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User info</title>
</head>
<body>

<h1>Name: ${user.fullName}</h1>
<h1>Username: ${user.username}</h1>
<h1>Password: ************</h1>
<img src="${user.imgPath}" alt="bu rasm">
</body>
</html>
