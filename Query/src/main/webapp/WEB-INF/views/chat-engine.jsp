<%@page import="java.util.Date"%>
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
<c:forEach items="${Chat}" var="entry">
   <p> ${entry.key} ${entry.value}</p>
</c:forEach>

<form action="/post-comment" method="post">
<div>
<textarea name="comments" id="comments" style="font-family:sans-serif;font-size:1.2em;">
Type here
</textarea>
</div>
<input type="submit" value="Submit">
</form>
</body>
</html>