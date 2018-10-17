<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>I am a JSP</title>
</head>
<body>

<form action="/login.do" method="post">
<p><font color="red">${errorMessage}</font></p>
Name <input type="text" name="pangalan" placeholder="name"/>
Password <input type="password" name="hudyat"/> 
<input type="submit" value="Login"/>

</form>

<!-- Valid user - welcome.jsp -->
<!-- Invalid user - login.jsp -->


<!-- http://localhost:8080/login.dot?name=Monteros&password=some -->
<%-- I am ${pangalan}
My password is ${hudyat} --%>

</body>
</html>