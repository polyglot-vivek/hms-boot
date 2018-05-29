<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Hospital</title>
</head>
<body>
<table  width="500" height="600" align="center">
		<tr>
			<td>Hospitals</td>
		</tr>
		<tr>
			<form:form action="updateHospital" method="post" modelAttribute="hosp">
			<th>Hospital Name</th><td><form:input path="name"/></td>
		</tr>
		<tr>
			<th>Address :</th><td><form:hidden path="id"/></td>
		</tr>
		<tr>
			<th>Town</th><td><form:input path="town"/></td>
		</tr>
		<tr>
			<th>Landmark</th><td><form:input path="landmark"/></td>
		</tr>
		<tr>
			<th>City</th><td><form:input path="city"/></td>
		</tr>
		<tr>
			<th>State</th><td><form:input path="state"/></td>
		</tr>
		<tr>
			<th>Zip Code</th><td><form:input path="zipcode"/></td>
		</tr>
		<tr>
			<th>Email</th><td><form:input path="email"/></td>
		</tr>
		<tr>
			<th>Phone</th><td><form:input path="phone"/></td>
		</tr>
		<tr>
			<th>Fax</th><td><form:input path="fax"/></td>
		</tr>
		<tr>
			<th>Status</th>
			<td>
			<c:choose>
				<c:when test="${hosp.getStatus() eq true}">
					<input type="radio" name="status" value="true" checked="checked">Active &nbsp; 
					<input type="radio" name="status" value="false">Inactive
				</c:when>
				<c:otherwise>
					<input type="radio" name="status" value="true">Active &nbsp; 
					<input type="radio" name="status" value="false" checked="checked">Inactive
				</c:otherwise>
			</c:choose>
			</td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Update"> &nbsp; <input type="reset" value="Reset"></td>
			</form:form>
		</tr>
	
	</table>
</body>
</html>