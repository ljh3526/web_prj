<%@page import="sk.didimdol.model.NameCardDAO"%>
<%@page import="sk.didimdol.model.NameCard"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%!
NameCardDAO dao = new NameCardDAO();
%>
<%
String id = request.getParameter("id");

NameCard card = dao.selectNameCard(Integer.parseInt(id));

request.setAttribute("card", card);

request.setAttribute("cards", dao.selectAllNameCards());
%>
<jsp:forward page="/nameCardView.jsp"></jsp:forward>