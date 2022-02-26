/*loginCheck.js */

 $(document).ready(function(){
	$('#loginForm').on('submit', function(){
		event.preventDefault();
		
		$.ajax({
			type: "post",
			url: "login",
			data: {"memId" : $('#memId').val(),
						"memPw": $('#memPw').val()},
			dataType:"text",
			success:function(result){
			
				if(result == "success"){
					alert("로그인성공! \n index페이지로 이동합니다.");
					location.href="/";
				}else{
					alert("등록된 회원이 아닙니다.")
				}
			},
			error:function(data, textStatus){
				alert(result);
				alert("전송실패");
			}
				
		});
			
	});
});