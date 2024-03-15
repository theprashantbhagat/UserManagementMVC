<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View All User</title>

<script>
function confirmDelete(){
return confirm("Are You Sure to Delete User Record.......");
}
</script>

</head>
<body>
<table border=5 bgcolour="lightpink">
<tr>
<th>User Name</th>
<th>User Email</th>
</tr>

<tbody>
<c:forEach items="${user}" var="cot">
<tr>
<td>${cot.userName}</td>
<td>${cot.userEmail}</td>

<td> <a href="edit?userId=${cot.userId}">Edit </a> </td>
<td> <a href="delete?userId=${cot.userId}" onclick ="return confirmDelete()">Delete <a/> </td>

</tr>
</c:forEach>
</tbody>
</table>

</body>
</html>