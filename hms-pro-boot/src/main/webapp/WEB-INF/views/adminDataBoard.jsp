<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1" width="700" align="center">
<tr height="50">
<td>Admins</td>
</tr>
<tr>
<td><a href="adminAddForm">Add New</a>&nbsp;&nbsp;<a href="deleteAdmin?select=${select}">Delete</a>&nbsp;&nbsp;<a href="activeAdmin">Active</a>&nbsp;&nbsp;<a href="inactiveAdmin">Inactive</a>&nbsp;&nbsp;<a href="showAllAdmin">Show All</a></td>
</tr>
<tr>
<td colspan="5">
<%-- <c:choose>
<c:when test="${admins ne null}"> --%>
	<table width="700" border="1" >
	<tr>
		<th></th><th>First name</th>
		<th>Last name</th><th>Email</th>
		<th>Mobile</th><th>Status</th>
		<th>Edit</th><th>Delete</th>
	</tr>
	<c:forEach items="${admins}" var="admin"> 
	<tr>
		<td><input type="checkbox" name="select[]" value="${admin.getAdminid()}"></td><td>${admin.getFname()}</td>
		<td>${admin.getLname()}</td><td>${admin.getEmail()}</td>
		<td>${admin.getMobile()}</td><td>${admin.isStatus()}</td>
		<td><a href="editadmin?id=${admin.getAdminid()}">Edit</a></td><td><a href="deleteAdmin?id=${admin.getAdminid()}">Delete</a></td>
	</tr>
	</c:forEach>
</table>
<%-- </c:when> --%>
<%-- <c:otherwise>
	<h4>No data Found.....!!!!!!!!</h4>
</c:otherwise>
</c:choose> --%>
</td>
</tr>
</table>
</body>
</html>