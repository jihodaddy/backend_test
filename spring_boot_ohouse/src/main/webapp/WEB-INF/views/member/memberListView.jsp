<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원정보관리</title>
	</head>
	<body>
	<div id="wrapper">
		<!-- TOP  -->
		<jsp:include page="/WEB-INF/views/layout/top.jsp" flush='ture'></jsp:include>

			<section>
				<table class="table">
					<tr>
						<td>아이디</td>
						<td>비밀번호</td>
						<td>이름</td>
						<td>이메일</td>
						<td>가입일</td>
					</tr>
					
					<c:forEach items="${memList}" var="mem" >
						<tr>
						<td>${mem.memId}</td>
						<td>${mem.memPw}</td>
						<td>${mem.memName}</td>
						<td>${mem.memEmail}</td>
						<td>${mem.memJoinDate}</td>
					</tr>
					
					
					</c:forEach> 
				</table>
			</section>
			
	</div>
	</body>
</html>