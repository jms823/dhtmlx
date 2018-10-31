<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String ppage = request.getParameter("page");
	if (ppage != null) {
		ppage += ".jsp";
	}else{
		ppage = "r1.jsp";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
</head>
<style>
#leftDiv {
	background: yellowgreen;
	width: 400px;
	height: 300px;
	display: block;
}

#leftDiv .select {
	font-size: 70px;
	width: 200px;
	height: 100px;
}

#rightDiv {
	background: pink;
	width: 400px;
	height: 300px;
}
</style>
<body>
	<div id="leftDiv">
		<jsp:include page="left.jsp"></jsp:include>
	</div>
	<div id="rightDiv">
		<jsp:include page="<%=ppage%>"></jsp:include>
	</div>
</body>
</html>