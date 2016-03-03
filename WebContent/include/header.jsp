<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setBundle basename="Menu"/>
<h1>헤더입니다.</h1>
<h3><fmt:message key="MENU1"/>, 
<fmt:message key="MENU2"/>, 메뉴3</h3>
<%= request.getParameter("num") %>