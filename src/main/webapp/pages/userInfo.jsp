<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>www.bikkadit.com</title>
</head>
<body bgcolor="lightpink">


<marquee>
<h1>
Bikkad IT-User-Registrations
</h1>
</marquee>


<font color="green">${Success} </font>
<font color="red">${Fail} </font>

<form:form action="saveUsers?userId=${user.userId}"
 modelAttribute="user" method="POST">

<table align="center">
<tr>
<td>UserName</td>
<td><form:input path="userName"/></td>
</tr>

<tr>
<td>UserEmail</td>
<td><form:input path="userEmail"/></td>
</tr>


<td><input type="submit" value="save" /></td>
</tr>

</table>
<div align="center">
<a href="viewAllUser" >View All Users</a>
</div>
</form:form>

</body>
</html>