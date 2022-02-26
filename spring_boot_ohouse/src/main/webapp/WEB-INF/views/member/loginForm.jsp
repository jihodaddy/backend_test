<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>로그인</title>
		 <script src="<c:url value='/js/jquery-3.6.0.min.js'/>"></script>
		<script src="<c:url value='/js/login.js'/>"></script>
		<style type="text/css">
			
			#loginBox{ text-align:center;	}
			#idBox,#pwBox{width:400px; height:48px; border:1px solid black; background:white;}
			#idBox{   margin-top: 25px;}
			#pwBox{ margin-top: 13px;}
			#loginBox input{
			    border:none;
			    width: 365px;
			    margin-top: 10px;
			    font-size: 14px;
			    margin-left: 10px;
			    height:30px;
			}
			
			#loginButton{
			    width: 400px;
			    height: 40px;
			    margin-top: 13px;
			    font-size: 18px;
			    background: lightblue;
			    color: white;
			    border: solid 1px black;
			}
		</style>
	</head>
	<body>
	<div id="wrapper">
		<!-- TOP  -->
		<jsp:include page="/WEB-INF/views/layout/top.jsp" flush='ture'></jsp:include>
	
		<section>
			<div id="loginBox">
				<form id="loginForm" name="loginForm">
					<h2>로그인</h2>
					<div id="idBox"><input type="text" id="memId" name="memId" placeholder="아이디"/></div>
					<div id="pwBox"><input type="password" id="memPw" name="memPw" placeholder="비밀번호"/></div>
					<div><button type="submit" id="loginButton">로그인</button></div>
				</form>
			</div>
		</section>
		
	</div>
	</body>
</html>