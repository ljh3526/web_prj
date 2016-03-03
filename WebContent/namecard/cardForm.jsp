<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>NameCard Form</h1>
<form action='<c:url value="${empty namecard ? '/namecard/insert.do' : '/namecard/update.do' }"/>' method="post">

<!-- <c:if test="${empty namecard }">
<form action='<c:url value="/namecard/insert.do" />' method="post" ></c:if>
<c:if test="${!empty namecard }">
<form action='<c:url value="/namecard/update.do" />' method="post" ></c:if> -->

NAME : <input type="text" name="name" value="${namecard.name }"><br>
EMAIL : <input type="email" name="email" value="${namecard.email }"><br>
AGE : <input type="number" name="age" value="${namecard.age }"><br>
<input type="hidden" name="id" value="${namecard.id }">
<input type="submit" value="저장ㅋ">
</form>
</body>
</html>