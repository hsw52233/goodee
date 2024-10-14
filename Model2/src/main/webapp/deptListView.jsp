<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "vo.*" %>
<%@ page import = "dao.*" %>
<%@ page import = "java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>deptno</td>
			<td>dname</td>
			<td>loc</td>
		</tr>
		<%
			List<Dept> list = (List<Dept>)(request.getAttribute("list"));
			for(Dept d : list) {
		%>
				<tr>
					<td><%=d.getDeptno()%></td>
					<td><%=d.getDname()%></td>
					<td><%=d.getLoc()%></td>
				</tr>
		<%		
			}
		%>
	</table>
</body>
</html>
