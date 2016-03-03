<%@page import="sk.didimdol.model.CalcBean"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%!
CalcBean bean = new CalcBean();
%>
<%
//파라미터 받아서...
String str1 = request.getParameter("a");
String str2 = request.getParameter("b");
//형변환 하고...
int a = Integer.parseInt(str1);
int b = Integer.parseInt(str2);

//Model의 biz() 메서드 호출하고
int result = bean.add(a, b);

//결과를 request에 저장하고
request.setAttribute("result", result);

//view로 forward 한다.
//RequestDispatcher disp = request.getRequestDispatcher("calcResult.jsp");
//disp.forward(request, response);
%>
<jsp:forward page="calcResult.jsp" />


