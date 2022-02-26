<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원가입</title>
	</head>
	<body>
	<div id="wrapper">
		<!-- TOP  -->
		<jsp:include page="/WEB-INF/views/layout/top.jsp" flush='ture'></jsp:include>

			<section>
				<form id="joinForm" name="newMemberForm" method="post" action="/insertMember">
				<div id="joinWrap">
					<h3>회원가입</h3>
					<div>
						<label>아이디</label>
						<div id="idRule"></div>
						<div><input type="text" id="memId" name="memId" placeholder="아이디"/></div>
					</div>	
					<div>
						<label>비밀번호</label>
						<div id="pwRule">영문,숫자를 포함한 8자 이상의 비밀번호를 입력해주세요.</div>
						<div><input type="password" id="memPw" name="memPw"/></div>
					</div>
					<div>
						<label>비밀번호 확인</label>
						<div><input type="password" id="memPwChk" name="memPwChk"/></div>
					</div>
					<div>
						<label>이름</label>
						<div><input type="text" id="memName" name="memName" placeholder="이름"/></div>
					</div>
					<div>
						<label>이메일</label>
						<div id="emailRule"></div>
						<div><input type="text" id="memEmail" name="memEmail" placeholder="이메일"/>@
								 <select name="email" id="emailSelect">
                                    <option value="선택하세요">선택하세요</option>
                                    <option value="gmail">gmail.com</option>
                                    <option value="naver" >naver.com</option>
                                    <option value="hanmail">hanmail.net</option>
                                    <option value="nate">nate.com</option>
                                </select>   
						</div>
					</div>	
						<div><button type="submit" id="joinButton">회원가입</button></div>
					<div>
						이미 아이디가 있으신가요?
						<a href="<c:url value='/login'/>">로그인</a>
					</div>
				</div>
				</form>
			</section>
		
	</div>
	</body>
</html>