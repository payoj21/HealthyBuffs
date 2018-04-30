<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>from jsp</title>
</head>
<body>
<!--  The below written code is a scripplet -->
<%
Date date = new Date();
%>
<!--The used variable is expression language-->
Hello ${name}
<!-- Below scripplet expression is used-->
<p>Current Date is <%=date%>
<p><font color="red">${error}</font></p>
<form action="/login" method="post">
<input type ="text" name="name"/>
<input type ="password" name="password"/>
<input type="submit"/>
</form>
</body>
</html>