<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1" width="900" align="center">
		<tr>
			<td>Hospitals</td>
		</tr>
		<tr>
			<td colspan="5"><a href="hospitalAddForm">Add New</a> &nbsp;
			<a href="deleteHospitals">Delete</a> &nbsp;
			<a href="activeHospital">Active</a> &nbsp;
			<a href="inactiveHospital">Inactive</a> &nbsp;
			<a href="getAllHospitals">Show All</a></td>
		</tr>
		<tr>
			<td colspan="5">
				<table width="900" border="1">
					<tr>
						<th></th>
						<th>Hospital Name</th>
						<th>Address</th>
						<th>Email</th>
						<th>Phone</th>
						<th>Fax</th>
						<th>Status</th>
						<th>Edit</th>
						<th>Delete</th>
				  </tr>
	 <c:forEach items="${hospitals}" var="hosp">
	<tr>
		<td></td>
		<td>${hosp.getName()}</td>
		<td>${hosp.getTown()} , ${hosp.getLandmark()} <br>
			${hosp.getCity()} , ${hosp.getState()} <br>
			${hosp.getZipcode()}</td>
		<td>${hosp.getEmail()}</td>
		<td>${hosp.getPhone()}</td>
		<td>${hosp.getFax()}</td>
		<td>${hosp.getStatus()}</td>
		<td><a href="editHospital?id=${hosp.getId()}">Edit</a></td>
		<td><a href="deleteHopsital?id=${hosp.getId()}">Delete</a></td>
	</tr>
	</c:forEach>
</table>
</td>
</tr>
<tr>
	<td colspan="5">
<c:forEach begin="1" end="${pages}" var="page">
	<button type="${page}"><a href="getAllHospitalsPagi?pageNo=${page}">${page}</a></button>
</c:forEach>
	</td>	
</tr>
</table>
</body>
</html>