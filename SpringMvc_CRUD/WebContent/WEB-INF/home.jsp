<%@page import="java.util.ArrayList"%>
<%@page import="com.anusha.model.Department"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
h1 {
	color: red;
}
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
	padding: 15px;
	text-align: left;
}
.top {
	background-color: #eee;
	width: 100%;
	height: 20%;
	text-align: center;
}
</style>
<title><spring:message code="label.getall"></spring:message></title>
</head>
<body>
	<div class="top">
		<h2>
			<a href="/SpringMvc_CRUD?siteLanguage=en">English</a>
		</h2>
		|
		<h2>
			<a href="/SpringMvc_CRUD?siteLanguage=fr">French</a>
		</h2>
	</div>
	<form:errors path="department.*"></form:errors>

	<c:if test="${Register eq 'newform'}">
		<form action="CreateDepartment" method="post">
	</c:if>
	<c:if test="${Register ne 'newform'}">
		<form action="CreateDepartment" method="post">
	</c:if>

	<table border="2" style="width: 100%"background-color:#eee;>
		<thead>
			<tr>
				<th colspan="2" , align="center"><h1>
						<spring:message code="label.details"></spring:message>
					</h1></th>
				<th colspan="2" , align="center"><a href="NewDepartment"><h2>
							<spring:message code="label.insertnew"></spring:message>
						</h2></a></th>
			</tr>
			<tr>
				<th><spring:message code="label.DeptID"></spring:message></th>
				<th><spring:message code="label.DeptName"></spring:message></th>
				<th><spring:message code="label.Update"></spring:message></th>
				<th><spring:message code="label.Delete"></spring:message></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${DeptList}" var="dept">

				<c:if test="${departmentid eq dept.deptID}">
					<tr>
						<td><input type="text" name="DeptID" value="${dept.deptID}"
							readonly="readonly" /></td>
						<td><input type="text" name="DeptName"
							value="${dept.deptName}" /></td>
						<td><input type="submit"
							value="<spring:message code="label.Update"></spring:message>" /></td>
					</tr>
				</c:if>
				<c:if test="${departmentid ne dept.deptID}">
					<tr>
						<td><c:out value="${dept.deptID}" /></td>
						<td><c:out value="${dept.deptName}" /></td>
						<td><a href="GetDepartment?DeptID=${dept.deptID}"><spring:message
									code="label.Update"></spring:message></a></td>
						<td><a href="DeleteDepartment?DeptID=${dept.deptID}"><h3>
									<spring:message code="label.Delete"></spring:message>
								</h3></a></td>
					</tr>
				</c:if>
			</c:forEach>
			<c:if test="${createdept eq 'newdept'}">
				<tr>
					<td><input type="text" name="DeptID" /></td>
					<td><input type="text" name="DeptName" /></td>
					<td colspan="2"><input type="submit"
						value="<spring:message code="label.S"></spring:message>" /></td>
				</tr>
			</c:if>
		</tbody>
	</table>
	</form>
</body>
</html>