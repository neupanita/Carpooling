$(document).ready(function() {
	var user_id = $("#userId").val();
	
	$.ajax({
		url:'OfferPost',
		type:'POST',
		headers:{
			Accept:"application/json; charset=utf-8",
			"Content-Type" : "application/json; charset=utf-8"
		},
		success:function(result) {
			$.each(result.JSONDATA,function(i, post) {
				
				if(post.userId == user_id){
					delete_html = "<div class='post-header'>" +
    									"<a href='#' class='deletepost' delete-post-id='"+ post.postId +"'>" +
    										"<span class='glyphicon glyphicon-trash pull-right  data-toggle='tooltip' title='Delete Post''></span>" +
    									"</a>" +
    								"</div>";
				}else{
					delete_html = "";
				}
				
				var myHTML="";
				myHTML+="<div class='post'>" +
				delete_html +
				"<div class='post-container'>" +
				"<p><span>Post Type: </span>" + post.postType + "</p>" +
				"<p><span>User Id: </span> " + post.userId + "</p>" +
				"<p><span>Post: </span> " + post.post + "</p>" +
				"<p><span>Date: </span>" + post.dateUpdated + "</p>" +
				
				"</div>" + 
					"<div class='post-footer'>" +
						"<form id='like-form' method='POST' action='AddLike'>" +
							"<button class='btn btn-info btnLike' value=\"" + post.postId + "\">" +
								"<input name='post-id' type='hidden' value="+post.postId+">" +
								"<span class='glyphicon glyphicon-thumbs-up'></span>  Like    " +
								"<span id='like-count-" + post.postId + "' class='badge'></span>" +
							"</button>    " +
						"</form>" +
						"<button class='btn btn-info btnComment' value=\"" + post.postId + "\">Comment</button></div>" +
						"<br>" +
						
						"<div class='panel panel-primary comment-box' id='comment-box-"+post.postId+"'>" +
							"<div class='panel-heading'>" +
						    	"Panel Heading" +
						    "</div>" +
						    "<div id='comment-"+post.postId+"' class='panel-body'>Panel Body</div>" +
						    
						    "<form id='add-comment-form' method='POST' action='AddComment'>" +
						    	"<div class='input-group'>" +
						    		"<input name='new-comment'id='add-comment-text"+post.postId+"' type='text' placeholder='Write a Comment' class='form-control' aria-label='...'>" +
						    		"<input name='post-id' type='hidden' value="+post.postId+">" +
						    		"<div class='input-group-btn'>" +
						    		"<button id='add-comment-btn-"+post.postId+"'type='submit' class='btn btn-primary'>Add Comment</button>" +
						    		"</div>" +
						    	"</div>" +
						    "</form>"
						"</div>" +
					"</div>" +
					
				"</div>";
				$("#offer").append(myHTML);
			});
		},
		error:function(exception){
			console.log(exception);
		}
	});

	$.ajax({
		url:'RequestPost',
		type:'POST',
		headers:{
			Accept:"application/json; charset=utf-8",
			"Content-Type" : "application/json; charset=utf-8"
		},
		success:function(result){
			$.each(result.JSONDATA,function(i,post){
				if(post.userId == user_id){
					delete_html = "<div class='post-header'>" +
    									"<a href='#' class='deletepost' delete-post-id='"+ post.postId +"'>" +
    										"<span class='glyphicon glyphicon-trash pull-right  data-toggle='tooltip' title='Delete Post''></span>" +
    									"</a>" +
    								"</div>";
				}else{
					delete_html = "";
				}
				var myHTML="";
				myHTML+="<div class='post'>" +
				delete_html +
				"<div class='post-container'>" +
				"<p><span>Post Type: </span>" + post.postType + "</p>" +
				"<p><span>User Id: </span> " + post.userId + "</p>" +
				"<p><span>Post: </span> " + post.post + "</p>" +
				"<p><span>Date: </span>" + post.dateUpdated + "</p>" +
				
				"</div>" + 
					"<div class='post-footer'>" +
						"<a href='#' class='btn btn-info'>" +
							"<span class='glyphicon glyphicon-thumbs-up'></span> Like" +
							"</a>          " +
							"<button class='btn btn-info btnComment' value=\"" + post.postId + "\">Comment</button></div>" +
							"<br>" +
							
							"<div class='panel panel-primary comment-box' id='comment-box-"+post.postId+"'>" +
								"<div class='panel-heading'>" +
							    	"Panel Heading" +
							    "</div>" +
							    "<div id='comment-"+post.postId+"' class='panel-body'>Panel Body</div>" +
							    
							    "<form id='add-comment-form' method='POST' action='AddComment'>" +
							    	"<div class='input-group'>" +
							    		"<input name='new-comment'id='add-comment-text"+post.postId+"' type='text' placeholder='Write a Comment' class='form-control' aria-label='...'>" +
							    		"<input name='post-id' type='hidden' value="+post.postId+">" +
							    		"<div class='input-group-btn'>" +
							    		"<button id='add-comment-btn-"+post.postId+"'type='submit' class='btn btn-primary'>Add Comment</button>" +
							    		"</div>" +
							    	"</div>" +
							    "</form>"
							"</div>" +
						"</div>" +
						
					"</div>";
				$("#request").append(myHTML);
			});
		},
		error:function(exception){
			console.log(exception);
		}
	});
	

	$(document.body).on("click",".deletepost",function(){
		var confirmation = confirm("Are you sure you want to delete this post?");
		if(confirmation){
			var self=$(this);
			var postId = self.attr("delete-post-id");
			
			$.post("DeletePost",{postId:postId}).done(function(result){
				
				if(result.JSONMESSAGE == "DeleteSuccess"){
					self.parent().parent().remove();
				}

				}).fail(function(xhr,status,exception){
					alert(exception);
					console.log(xhr);
			});
		}
	});
});