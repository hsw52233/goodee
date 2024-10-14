<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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

<%


		// MODEL1  : jsp(C + V) -> jsp(c) + jsp(v)
		// MODEL2  : jsp(c) + jsp(v) -> servlet(c) + jsp(v);
		//  -> JSP(v)를 클라이언트가 접근할 수 없는 폴더 (/WEP-INF)로 이동

		List<Emp> list = (List<Emp>)(request.getAttribute("list"));
		int currentPage = (int)(request.getAttribute("currentPage"));
		String word = (String)(request.getAttribute("word"));

%>

<table border="1">
		<tr>
			<td>empno</td>
			<td>ename</td>
			<td>deptno</td>
		</tr>
		<%
			
			for(Emp e : list) {
		%>
				<tr>
					<td><%=e.getEmpno()%></td>
					<td><%=e.getEname()%></td>
					<td><%=e.getDeptno()%></td>
					
				</tr>
		<%		
			}
		%>
	</table>
	
	<form action="<%=request.getContextPath()%>/empList" method="get">
			<input type = "text" name = "word">
			<button type="submit">검색</button>
	</form> 
	
	
	<div>
		<%
			if(word == null) {
		%>
				<a href="<%=request.getContextPath()%>/empList?currentPage=<%=currentPage-1%>">이전</a>
				<a href="<%=request.getContextPath()%>/empList?currentPage=<%=currentPage+1%>">다음</a>
		<%		
			} else {
		%>
				<a href="<%=request.getContextPath()%>/empList?currentPage=<%=currentPage-1%>&word=<%=word%>">이전</a>
				<a href="<%=request.getContextPath()%>/empList?currentPage=<%=currentPage+1%>&word=<%=word%>">다음</a>
		<%		
			}
		%>
	</div>


</body>
</html>