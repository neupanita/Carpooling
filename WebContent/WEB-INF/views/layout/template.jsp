<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<tiles:importAttribute name="javascripts"/>
<tiles:importAttribute name="stylesheets"/> 
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><tiles:insertAttribute name="title" ignore="true" /></title>

    <c:forEach var="css" items="${stylesheets}">
        <link rel="stylesheet" type="text/css" href="<c:url value="${css}"/>">
    </c:forEach>
</head>

<body>

    <div class="header">
		<tiles:insertAttribute name="header" />
    </div>

    <div class="container">
        <div class="container-fluid">
            <div class="row">
            	<div class="col-sm-3 col-md-2 sidebar">
            		<tiles:insertAttribute name="menu" />
                </div>
                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                    <tiles:insertAttribute name="body" />
				</div>
            </div>
        </div>
    </div>

    <c:forEach var="script" items="${javascripts}">
        <script src="<c:url value="${script}"/>"></script>
    </c:forEach>
</body>

</html>