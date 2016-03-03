<%@ page contentType="text/html; charset=EUC-KR"
    isErrorPage="true"%>
<% response.setStatus(200); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>에러 페이지</title>
</head>
<body>
<h1>서버 오류</h1>
에러 타입 <%= exception.getClass().getName() %><br>
에러 메시지 <%= exception.getMessage() %>
</body>
</html>