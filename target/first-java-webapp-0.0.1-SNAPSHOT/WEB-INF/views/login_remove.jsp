<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script type="text/javascript" src="/resources/lib/jquery-1.12.3.min.js"></script>
<script type="text/javascript" src="/resources/js/signup_lightbox.js"></script>
<link rel="stylesheet" type="text/css" href="/resources/css/style.css">
<title>I am a JSP</title>
</head>
<body>

<%-- <form action="/login" method="post">
<p><font color="red">${errorMessage}</font></p>
Name <input type="text" name="pangalan" placeholder="name"/>
Password <input type="password" name="hudyat"/> 
<input type="submit" value="Login"/> --%>


  <div class="lightbox">
    <h2>Lightbox</h2>
    <p>
      Paragraph here
    </p>
    <form action="/login" method="post">
      <p><font color="red">${errorMessage}</font></p>
		Name <input type="text" name="pangalan" placeholder="name"/>
		Password <input type="password" name="hudyat"/> 
		<input type="submit" value="Login"/>
    </form>
  </div>

</form>

<!-- Valid user - welcome.jsp -->
<!-- Invalid user - login.jsp -->


<!-- http://localhost:8080/login.dot?name=Monteros&password=some -->
<%-- I am ${pangalan}
My password is ${hudyat} --%>

</body>
</html>