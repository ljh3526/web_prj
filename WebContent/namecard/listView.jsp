<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>NameCard List Information</h1>
<c:forEach var="nameCard" items="${cardList}">
	${nameCard.id }, ${nameCard.name }, ${nameCard.email }, ${nameCard.age } 
<a href='<c:url value="/namecard/selectCard.do?id=${nameCard.id}" />' >[수정]</a>
<a href='<c:url value="/namecard/delete.do?id=${nameCard.id}" />' >[삭제]</a>
<br>
</c:forEach>
<br>
<a href='<c:url value="/namecard/cardForm.jsp" />' >[입력]</a>
</body>
</html>