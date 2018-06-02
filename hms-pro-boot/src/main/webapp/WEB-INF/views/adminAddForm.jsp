<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Admins</h3>
<table>
<form:form action="saveAdmin"  method="post" modelAttribute="admin">
	<tr><td>Hospital</td><td></td><td></td></tr>
	<tr><td><form:select path="hospName">
		<form:options items="${hosp}"/>
	</form:select></td><td></td><td></td></tr>
	<tr><td>First name</td><td>Last name</td><td>Email</td></tr>
	<tr><td><form:input path="fname"/></td><td><form:input path="lname"/></td><td><form:input path="email"/></td></tr>
	<tr><td>Mobile</td><td>User Id</td><td>Password</td></tr>
	<tr><td><form:input path="mobile"/></td><td><form:input path="userid"/></td><td><form:password path="password"/></td></tr>
	<tr><td>Status</td><td></td><td></td></tr>
	<tr><td><form:radiobuttons path="status" items="${stat}" /></td><td></td><td></td></tr>
	<tr></tr>
	<tr><td colspan="5"><input type="submit" value="Add"> &nbsp; <input type="reset" value="Reset"></td></tr>
</form:form>
</table>
</body>
</html>