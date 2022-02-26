<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

			<section>
				
				<form action="/dbsave">
					<input type="submit" value="db에저장" />
					<input type="hidden" name="command" value="listdb" /> <!-- 리스트 db에 데이저 저장 요청  -->
					<table border="1">
					
					</table>
				</form>
			
			
			
			</section>

		
	</div>
	</body>
</html>