<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>top</title>
        <script src="<c:url value='/js/jquery-3.6.0.min.js'/>"></script>
        <link href="css/bootstrap.min.css" rel="stylesheet">
	    <link rel="stylesheet" href="<c:url value='/css/common.css'/>" >
        <script src="<c:url value='/js/bootstrap.min.js'/>"></script>
        
	</head>
	<body>
			<header>
				<div>배너1</div>
				<div>배너2</div>
			</header>
			
			<nav class="navbar navbar-default">
				  <div class="container-fluid">
				    <div class="navbar-header">
				      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				        <span class="sr-only">Toggle navigation</span>
				        <span class="icon-bar"></span>
				        <span class="icon-bar"></span>
				        <span class="icon-bar"></span>
				      </button>
				      <a class="navbar-brand" href="/index">연습 사이트</a>
				    </div>
				
				    <!-- Collect the nav links, forms, and other content for toggling -->
				    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				      <ul class="nav navbar-nav">
				        <li class="active"><a href="#">커뮤니티 <span class="sr-only">(current)</span></a></li>
				      
				        <li class="dropdown">
				          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">스토어 <span class="caret"></span></a>
				          <ul class="dropdown-menu" role="menu">
				            <li><a href="#">스토어홈</a></li>
				            <li class="divider"></li>
				            <li><a href="#">카테고리</a></li>
				            <li><a href="#">베스트</a></li>
				            <li><a href="#">오늘의집</a></li>
				            <li><a href="#">생활용품특가</a></li>
				            <li><a href="#">패브릭핫딜</a></li>
				            <li><a href="#">리퍼마켓</a></li>
				            <li><a href="#">지정일배송</a></li>
				            <li><a href="#">프리미엄</a></li>
				            <li><a href="#">기획전</a></li>
				          </ul>
				        </li>
				        
				      </ul>
				      <form class="navbar-form navbar-left" role="search">
				        <div class="form-group">
				          <input type="text" class="form-control" placeholder="Search">
				        </div>
				        <button type="submit" class="btn btn-default">Submit</button>
				      </form>
				      <ul class="nav navbar-nav navbar-right">
				       <!-- 비로그인  -->
				       <c:if test="${empty sessionScope.sid}">
					        <li><a href="<c:url value='/loginForm'/>">로그인</a></li>
					        <li><a href="<c:url value='/joinForm'/>">회원가입</a></li>
				       </c:if>
				       <!-- 로그인  -->
				       	<c:if test="${not empty sessioScope.sid }">
				       		${ sessionScope.sid}  님 환영합니다. &nbsp;
				       		 <li><a href="<c:url value='/logout'/>">로그아웃</a></li>
				       	</c:if>
				       	
				    
				       		 <li><a href="<c:url value='logout'/>">로그아웃</a></li>
				       	
				       		<li><a href="<c:url value='/listAllMember'/>">멤버조회</a></li>
				       		
				       		<li class="dropdown">
					          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">AI&API <span class="caret"></span></a>
					          	<ul class="dropdown-menu" role="menu">
							        <li><a href="<c:url value='/clovaOCRForm'/>">OCR</a></li>
							        <li><a href="<c:url value='/drugForm'/>">e약은요 API</a></li>
							        <li><a href="<c:url value='/drugSave'/>">e약은요 API 저장 test</a></li>
							        <li><a href="<c:url value='/naver'/>">NAVER API검색</a></li>
							        <li><a href="<c:url value='/pubApi'/>">의약품허가정보 API:JSON</a></li>
					        	</ul>
				        	</li>
				        	<li><a href="#">고객센터</a></li>
				        	<li><a href="#">글쓰기</a></li>
		         	   	<c:if test="${not empty sessioScope.sid }">
					        <li class="dropdown">
					          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">관리자 <span class="caret"></span></a>
					          <ul class="dropdown-menu" role="menu">
					            <li><a href="<c:url value='listAllMember'/>">회원정보조회</a></li>
					            <li class="divider"></li>
					            <li><a href="#">회원정보수정/삭제</a></li>
					          </ul>
					        </li>
				       	</c:if>
				       	
				      </ul>
				    </div><!-- /.navbar-collapse -->
				  </div><!-- /.container-fluid -->
			</nav>
		
	</body>
</html>