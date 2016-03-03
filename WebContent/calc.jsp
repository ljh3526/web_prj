<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Page Title</title>
</head>
<body>
<%
String str1 = request.getParameter("a");
String str2 = request.getParameter("b");
int a = Integer.parseInt(str1);
int b = Integer.parseInt(str2);

int result = a+b; //계산
%>
계산 결과는 
<%
out.print(result);
%>
입니다.
</body>
</html>