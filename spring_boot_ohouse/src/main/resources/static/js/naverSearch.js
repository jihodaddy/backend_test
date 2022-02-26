/**
 * naverSearch.js
 */
 
 $(function(){
	$('#naverForm').on('submit', function(event){
		event.preventDefault();
				 
		$.ajax({
			url:"naverSearch",
			type:"post",
			data:{drugName : $('#drugName').val()},
            dataType :'json',
            success:function (result){
				
			console.log(result);
			
			var items = result.items;
			
			$('#resultDiv').empty();
			
			 for(var i=0; i<items.length; i++ ){
				$('#resultDiv').append("<img src='"+items[i].thumbnail+"' width='150' height='100'>")
				$('#resultDiv').append("<h3>"+items[i].title+"</h3>")
				$('#resultDiv').append("<p>"+items[i].link+"</p>")
				$('#resultDiv').append("<p>"+items[i].description+"</p>")
			}


								
			},
			error:function(){
				alert("오류가 발생했습니다.")
			}
		});
		
	});		
});