<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html> 
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>home page</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body>
		<input id="userId" type="hidden" value = "${userId}"/>
		<%
			String userSession = (String) session.getAttribute("userSession");
				if (userSession == null) {
					response.sendRedirect("index.jsp");
				}
		%>

    <div class="header">
    	<jsp:include page="/WEB-INF/views/layout/header.jsp" />
    </div>

    <div class="container">
        <div class="container-fluid">
            <div class="row">
            	<div class="col-sm-3 col-md-2 sidebar">
            		<jsp:include page="/WEB-INF/views/layout/menu.jsp" />
                </div>
                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                	<jsp:include page="/WEB-INF/views/addpost.jsp" />
                	<jsp:include page="/WEB-INF/views/posts.jsp" />
				</div>
            </div>
        </div>
    </div>

	<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	<script src="js/post.js" type="text/javascript"></script>
	<script src="js/comment.js" type="text/javascript"></script>
	<script src="js/like.js" type="text/javascript"></script>
</body>

</html>