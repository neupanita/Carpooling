<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<%String successMessage = (String) request.getAttribute("updateSuccess");
 	if (successMessage != null) {
 		out.println(request.getAttribute("updateSuccess"));
 %> <a href="WEB-INF/views/home.jsp">Home</a> <%
 	}
 %>

		<div id="editbox"
			class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Edit Profile</div>
				</div>
				<div class="panel-body">
					<form id="editform" class="form-horizontal" method="POST" action="Edit">

						<div class="form-group">
							<label for="fullname" class="col-md-3 control-label">Full
								Name</label>
							<div class="col-md-9">
								<input type="text" class="form-control" name="fullname"
									placeholder="Full Name" required="required" value="${fullname}" >
							</div>
						</div>

						<div class="form-group">
							<label for="email" class="col-md-3 control-label">Email</label>
							<div class="col-md-9">
								<input type="email" class="form-control" name="email" required="required"
									placeholder="Email" value="${email}">
							</div>
						</div>

						<div class="form-group">
							<label for="password" class="col-md-3 control-label">Password </label>
							 
							<div class="col-md-9">
								<input type="password" class="form-control" name="password"	placeholder="Password" pattern="^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{6,}$"
								title="should be at least 6 letters and have at least one capital letter, one small letter,one number ">
							</div>
						</div>

						<div class="form-group">
							<label for="gender" class="col-md-3 control-label">Gender</label>
							<div class="col-md-9">
								<select class="form-control" id="sel1" name="gender">
									<option value="1">Male</option>
									<option value="0">Female</option>
								</select>
							</div>

						<div class="form-group">
							<label for="state" class="col-md-3 control-label">State</label>
							<div class="col-md-9">
								<input type="text" class="form-control" name="state"
									placeholder="State" required="required" value="${state}">
							</div>
						</div>

						<div class="form-group">
							<label for="city" class="col-md-3 control-label">City</label>
							<div class="col-md-9">
								<input type="text" class="form-control" name="city"
									placeholder="City" required="required" value="${city}">
							</div>
						</div>

						<div class="form-group">
							<label for="street" class="col-md-3 control-label">Street</label>
							<div class="col-md-9">
								<input type="text" class="form-control" name="street"
									placeholder="Street" required="required" value="${street}">
							</div>
						</div>

						<div class="form-group">
							<label for="zipcode" class="col-md-3 control-label">Zip
								Code</label>
							<div class="col-md-9">
								<input type="text" class="form-control" name="zipcode"
									placeholder="Zip Code" required="required" value="${zipcode}">
							</div>
						</div>

						<div class="form-group">
							<label for="birthyear" class="col-md-3 control-label">Birth
								Year</label>
							<div class="col-md-9">
								<input type="text" class="form-control" name="birthyear"
									placeholder="Birth Year" required="required" value="${birthyear}" pattern="[1][\d][0-8][\d]|[1][\d][9][0-8]" title="Invalid Year: Four Digit Number or Must be Greater Than 18 Years">
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-offset-3 col-md-9">
								<button id="btn-signup" type="Edit Profile" class="btn btn-info">
								</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>