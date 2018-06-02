<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add new hospital</title>
</head>
<body>
	<table  width="500" height="600" align="center">
		<tr>
			<td>Hospitals</td>
		</tr>
		<tr>
			<form:form action="saveHospital" method="post" modelAttribute="hosp">
			<th>Hospital Name</th><td><form:input path="name"/></td>
		</tr>
		<tr>
			<th>Address :</th><td></td>
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
			<th>Status</th><td><input type="radio" name="status" value="true">Active &nbsp; 
							    <input type="radio" name="status" value="false">Inactive</td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Add"> &nbsp; <input type="reset" value="Reset"></td>
			</form:form>
		</tr>
	
	</table>
</body>
</html>