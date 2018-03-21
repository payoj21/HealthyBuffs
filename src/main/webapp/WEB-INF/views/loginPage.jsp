<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
   <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Login Page</title>

    <!-- Bootstrap -->
    <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
   <body>

      <form:form method = "POST" action = "/MVCSpring/loginPagePost">
      <div class="jumbotron">
        <h1>Electronic Medical Record System</h1>
        <h3>Sign in below!</h3>
        <p class="lead"><div class = "row">
   
      <div class="col-sm-4">
            <tr>
               <td><form:label class="form-control" path = "login_id">ID</form:label></td>
               <td><form:input class="form-control" path = "login_id" /></td>
            </tr>
            </div></div>
            <div class = "row">
    
      <div class="col-sm-4">
            <tr>
               <td><form:label class="form-control" path = "password">Password</form:label></td>
               <td><form:input class="form-control" type = "password" path = "password" /></td>
            </tr>
            </div></div></p>
        <p><input class="btn btn-primary" type = "submit" value = "Submit"/></p>
      </div>
         

      </form:form>
   <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
   </body>
</html>