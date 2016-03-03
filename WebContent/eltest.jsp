<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL Sample</title>
</head>
<body>
<%
String message = "Hello EL";
request.setAttribute("msg", message);
session.setAttribute("msg", "World EL");
%>

${10+20}<br>
<%= request.getAttribute("msg") %> = ${msg}<br>
${requestScope.msg} = ${requestScope["msg"]} = ${msg}<br>
${sessionScope.msg} != ${msg}<br>
${param}<br><!-- 모든 파라미터정보를 출력 -->
${param.name}<br><!-- name 파라미터 값을 출력 -->
p - ${paramValues}
${paramValues.name[0]}
${header}<br><!--  모든 헤더 정보 출력 -->
${header["user-agent"]}<br><!-- user-agent 헤더 정보 출력 -->
${header["cookie"]}<br><!-- cookie 출력 -->
${initParam.driver}<!-- web.xml 파일에 정의된 컨텍스트 초기화 파라미터 출력 -->
</body>
</html>

