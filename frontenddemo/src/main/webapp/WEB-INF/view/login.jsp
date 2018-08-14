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
<form action="validate" method="POST">
<h2>Login Form</h2>
 <div class="form-group">
  <label class="col-md-4 control-label">E-Mail</label>  
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
  <input name="username" placeholder="E-Mail Address" class="form-control"  type="text" required="" />
    </div>
  </div>
</div>
<div class="form-group">
  <label class="col-md-4 control-label" >Password</label> 
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input name="password" placeholder="Password" class="form-control"  type="password" required="" />
    </div>
  </div>
</div>
<input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
<div class="form-group">
  <div class="col-md-4"><br>
 <input type="submit" class="btn btn-warning"  name="butSubmit" value="Login">
  </div>
</div>
</form>
</div>
</body>
</html>