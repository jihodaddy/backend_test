<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	
	</head>
	<body>
	<div id="wrapper">
		<!-- TOP  -->
		<jsp:include page="/WEB-INF/views/layout/top.jsp" flush='ture'></jsp:include>

				
	<div id="outter">
			
		<table class="table">
			<tr>
				<td>이미지</td>
				<td>제품명</td>
				<td>업체명</td>
				<td>모양</td>
				<td>색상</td>
				<td>제형</td>
				<td>설명</td>
			</tr>
			
			<c:forEach items="${shapeList}" var="shape">
				<tr>
					<td><img src="${shape.itemImage}" alt="약모양" width="50px" height="25px"/></td>
					<td width="200px">${shape.itemName }</td>
					<td>${shape.entpName }</td>
					<td>${shape.drug_shape }</td>
					<td>${shape.color_class }</td>
					<td>${shape.form_code_name }</td>
					<td>${shape.class_name }</td>
				</tr>	
			</c:forEach>
		</table>			
	</div>
	
			
	</div> <!-- wrap -->
	</body>
</html>