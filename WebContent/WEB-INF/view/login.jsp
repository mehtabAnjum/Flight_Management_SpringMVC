<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ImageMgmt Login</title>

<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous"></script>

<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<script type="text/javascript" src="assets/js/script.js"></script>
<link rel="stylesheet" href="assets/style.css">
</head>
<body>

<h>
 ${message }
</h>
	<div class="container">
		<div class="row vertical-offset-100">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Login</h3>
					</div>
					<div class="panel-body">
						<form action="verify-login" modelAttribute="login" method="post">
							<fieldset>
								<div class="form-group">
									<input class="form-control" placeholder="UserName" name="userName"
										type="text" required="required">
								</div>
								<div class="form-group">
									<input class="form-control" placeholder="Password"
										name="password" type="password" required="required">
								</div>
								<div>
									<label> <span>Forgotten your password?</span>
									</label>
								</div>
								<input class="btn btn-lg btn-success btn-block" type="submit"
									value="Login">
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>