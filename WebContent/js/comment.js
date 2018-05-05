$(document.body).on("click", ".btnComment", showComments);

function showComments() {
	var user_id = $("#userId").val();
	var self=$(this);
	var postId = self.val();
	$("#comment-box-"+postId).toggle();
	$("#comment-"+postId).empty();
	
	$.post("Comment",{postId: postId}).done(function(result) {
		$.each(result.JSONDATA,function(i, comment) {

			var deleteBtn = "";
			var myHTML="";

			if(comment.userId == user_id) {
				deleteBtn += "<a href='#' id='delete-comment' delete-comment-id='"+comment.commentId+"'>" +
				"<span class='glyphicon glyphicon-menu-down pull-right  data-toggle='tooltip' title='Delete Comment''></span>" +
				"</a>";
			}

			myHTML+= "<div><span>" + comment.comment + "</span>"+deleteBtn+"<br/></div>";
			$("#comment-" + comment.postId).append(myHTML);
		});
	}).fail(function(xhr, status, exception) {
		alert(exception);
		console.log(xhr);
	});
}
	
$(document.body).on("click","#delete-comment", function() {
	var confirmation = confirm("Are you sure you want to delete this Comment?");
	if(confirmation) {
		var self = $(this);
		var commentId = self.attr("delete-comment-id");
		self.parent().remove();
		$.post("DeleteComment",{commentId:commentId}).done(function(result) {
			if(result.JSONMESSAGE == "DeleteSuccess") {
				self.parent().parent().remove();
			}
		}).fail(function(xhr,status,exception) {
			alert(exception);
			console.log(xhr);
		});
	}
});