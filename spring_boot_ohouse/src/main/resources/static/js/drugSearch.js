/**
 * drugSearch.js
 */
 
 $(function(){
	$('#drugForm').on('submit', function(event){
		event.preventDefault();
				 
		$.ajax({
			url:"drugInfo",
			type:"post",
			data:{drugName : $('#drugName').val()},
            dataType :'json',
            success:function (result){
				
				var items = result.body.items;
				$('#resultDiv').empty();
				
				 for(var i=0; i<items.length; i++ ){
				$('#resultDiv').append("<h3>이미지</h3>");
				$('#resultDiv').append("<img src='"+items[i].itemImage +"' width='150' height='100'>")
				$('#resultDiv').append("<h3>업체명</h3>");
				$('#resultDiv').append("<p>"+items[i].entpName +"</p>")
				$('#resultDiv').append("<h3>제품명</h3>");
				$('#resultDiv').append("<p>"+items[i].itemName +"</p>")
				$('#resultDiv').append("<h3>효능</h3>");
				$('#resultDiv').append("<p>"+items[i].efcyQesitm +"</p>")
				$('#resultDiv').append("<h3>복용방법</h3>");
				$('#resultDiv').append("<p>"+items[i].useMethodQesitm +"</p>")
				$('#resultDiv').append("<h3>주의사항</h3>");
				$('#resultDiv').append("<p>"+items[i].atpnQesitm +"</p>")
				$('#resultDiv').append("<h3>주의해야 할 약 또는 음식</h3>");
				$('#resultDiv').append("<p>"+items[i].intrcQesitm +"</p>")
				$('#resultDiv').append("<h3>이상반응</h3>");
				$('#resultDiv').append("<p>"+items[i].seQesitm +"</p>")
				$('#resultDiv').append("<h3>보관방법</h3>");
				$('#resultDiv').append("<p>"+items[i].depositMethodQesitm +"</p><hr>")
				}
								
			},
			error:function(){
				alert("오류가 발생했습니다.")
			}
		});
		
	});		
});