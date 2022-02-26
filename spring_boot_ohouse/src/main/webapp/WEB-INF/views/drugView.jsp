<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>약정보 검색</title>
		<script src="<c:url value='/js/jquery-3.6.0.min.js'/>"></script>
    	<script src="<c:url value='/js/drugSearch.js'/>"></script>
	</head>
	<body>
	<div id="wrapper">
		<!-- TOP  -->
		<jsp:include page="/WEB-INF/views/layout/top.jsp" flush='ture'></jsp:include>

				<h3>공공데이터API 약 정보 검색</h3>
		<%-- <form id="drugForm" method="post" action="<c:url value='/drugSearch'/>" > --%>
		<form id="drugForm">
			<input type="text" id="drugName" name="drugName">
			<input type="submit" value="결과 확인">
		</form>
		<br><br>
		
		<div id="resultDiv">
		</div>
		
	</div>
	</body>
</html>