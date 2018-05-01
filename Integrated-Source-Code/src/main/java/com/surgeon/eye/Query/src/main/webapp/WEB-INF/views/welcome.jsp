<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>from jsp</title>
</head>
<body>
<!--  The below written code is a scripplet -->
<!--The used variable is expression language-->
Welcome ${name}
The Doctors in your list are:
<c:forEach var="listValue" items="${docs}">
	<li><a href = /chat-engine?key=${listValue.key}>${listValue.value}</a></li>
</c:forEach>
</body>
</html>