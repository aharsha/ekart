<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib  uri="http://www.springframework.org/tags/form"   prefix="spform" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<spform:form  modelAttribute="pro"  action="readProduct"  method="post"  enctype="multipart/form-data">
ProductId <spform:input  path="productId"  />
ProductName <spform:input  path="productName" />
ProductPrice <spform:input  path="productPrice" />
ProductImage <spform:input type="file"   path="proImage" />
<input  type="submit"  value="addproduct" />
</spform:form>
</body>
</html>