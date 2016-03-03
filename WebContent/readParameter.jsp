<%@ page contentType="text/html; charset=EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
Hello<br>
<%= request.getRequestURI() %><br>
<%= request.getParameter("name").toUpperCase() %>
</body>
</html>