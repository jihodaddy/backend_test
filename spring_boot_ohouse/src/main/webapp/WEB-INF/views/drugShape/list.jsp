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
		<script src="<c:url value='/js/jquery-3.6.0.min.js'/>"></script>
        <link href="css/bootstrap.min.css" rel="stylesheet">
	    <link rel="stylesheet" href="<c:url value='/css/common.css'/>" >
        <script src="<c:url value='/js/bootstrap.min.js'/>"></script>
        
		<style>
			 .pageInfo{
			  	list-style : none;
			  	display: inline-block;
			    margin: 50px 0 0 100px;  	
			  }
			  .pageInfo li{
			  	float: left;
			    font-size: 20px;
			    margin-left: 18px;
			    padding: 7px;
			    font-weight: 500;
			  }
			#outter a:link {color:black; text-decoration: none;}
			#outter a:visited {color:black; text-decoration: none;}
			#outter a:hover {color:black; text-decoration: underline;}
					  	.active{
			  					background-color: #cdd5ec;
			  					}
		</style>
	
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
					<td><c:out value="${shape.entpName}"/></td>
					<td><c:out value="${shape.drug_shape }"/></td>
					<td><c:out value="${shape.color_class }"/></td>
					<td><c:out value="${shape.form_code_name }"/></td>
					<td><c:out value="${shape.class_name }"/></td>
				</tr>	
			</c:forEach>
		</table>		
		 <div class="pageInfo_wrap" >
			<div class="pageInfo_area">
				<ul id="pageInfo" class="pageInfo">
				
					<!-- 이전페이지 버튼 -->
					<c:if test="${pageMaker.prev}">
						<li class="pageInfo_btn previous"><a href="${pageMaker.startPage-1}">Previous</a></li>
					</c:if>
					
					<!-- 각 번호 페이지 버튼 -->
					<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
						<li class="pageInfo_btn ${pageMaker.cri.pageNum == num ? "active":"" }"><a href="${num}">${num}</a></li>
					</c:forEach>
					
					<!-- 다음페이지 버튼 -->
					<c:if test="${pageMaker.next}">
						<li class="pageInfo_btn next"><a href="${pageMaker.endPage + 1 }">Next</a></li>
					</c:if>	
					
				</ul>
			</div>
		</div>
		
		<form id="moveForm" method="get">	
			<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum }">
			<input type="hidden" name="amount" value="${pageMaker.cri.amount }">
			<input type="hidden" name="keyword" value="${pageMaker.cri.keyword }">	
			<input type="hidden" name="type" value="${pageMaker.cri.type }">	
		</form>
	</div>
	</div> <!-- wrap -->
		<script>
			$(document).ready(function(){
				
					let result = '<c:out value="${result}"/>';
					
					checkAlert(result);
					console.log(result);
					
					function checkAlert(result){
						
						if(result === ''){
							return;
						}
						
						if(result === "enrol success"){
							alert("등록이 완료되었습니다.");
						}
						
						if(result === "modify success"){
							alert("수정이 완료되었습니다.");
						}
						
						if(result === "delete success"){
							alert("삭제가 완료되었습니다.");
						}		
					}	
					
				});
					let moveForm = $("#moveForm");
					$(".move").on("click", function(e){
						e.preventDefault();
						
						moveForm.append("<input type='hidden' name='itemName' value='"+ $(this).attr("href")+ "'>");
						moveForm.attr("action", "/board/get");
						moveForm.submit();
					});
					$(".pageInfo a").on("click", function(e){
						e.preventDefault();
						moveForm.find("input[name='pageNum']").val($(this).attr("href"));
						moveForm.attr("action", "/drugShape/list");
						moveForm.submit();
						
					});	
					
					
					$(".search_area button").on("click", function(e){
						e.preventDefault();
						
						let type = $(".search_area select").val();
						let keyword = $(".search_area input[name='keyword']").val();
						
						if(!type){
							alert("검색 종류를 선택하세요.");
							return false;
						}
						
						if(!keyword){
							alert("키워드를 입력하세요.");
							return false;
						}		
						
						moveForm.find("input[name='type']").val(type);
						moveForm.find("input[name='keyword']").val(keyword);
						moveForm.find("input[name='pageNum']").val(1);
						moveForm.submit();
				});
				
		</script>
	
	
	
	</body>
</html>