$(document).ready(function() {
	$.ajax({
		url:'Like',
		type:'POST',
		headers:{
			Accept:"application/json; charset=utf-8",
			"Content-Type" : "application/json; charset=utf-8"
		},
		success:function(result) {
			$.each(result.JSONDATA,function(i, count) {
				$("#"+i).append(count);
			});
		},
		error:function(exception){
			console.log(exception);
		}
	});
});