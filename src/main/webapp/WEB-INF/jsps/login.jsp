<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springform"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<springform:form action="readLoginData"   method="post" modelAttribute="userdata"  >
UserName<springform:input  path="email"   />
Password <springform:input  path="password" />
<input type="submit"  value="Login" />


</springform:form>

</body>
</html>