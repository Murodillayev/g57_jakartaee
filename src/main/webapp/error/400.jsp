<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>Xato 400</title>
</head>
<body>
<h1>Bad Request</h1>

<!-- Bu yerda to‘g‘ridan-to‘g‘ri xabar chiqadi -->
<p style="color:red;">
    ${pageContext.errorData.message}
<%--    ${requestScope['javax.servlet.error.message']}--%>
</p>

<p>URI: ${pageContext.errorData.requestURI}</p>
<p>Status: ${pageContext.errorData.statusCode}</p>
</body>
</html>