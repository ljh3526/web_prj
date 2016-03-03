<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
Integer a = (Integer)session.getAttribute("a");
if(a!=null) {
	session.setAttribute("a", a + 1);
}else {
	session.setAttribute("a", 0);
}
%>
<% System.out.println(session.getAttribute("a")); %>
<% response.sendRedirect("b.jsp"); %>
</body>
</html>