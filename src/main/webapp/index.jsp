
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Simple Login Form Example</title>
  
  <link rel="stylesheet" href="style.css">

</head>
<body>
<!-- partial:index.partial.html -->
<div class="login-form">
  <form action="loginServ" method="post">
    <h1>Login</h1>
    <div class="content">
      <div class="input-field">
        <input type="email" id="email" name="email" placeholder="Email">
      </div>
      <div class="input-field">
        <input type="password" id="password" name="password" placeholder="Password">
      </div>
      <a href="#" class="link">Forgot Your Password?</a>
    </div>
    <div class="action">
      <button id="register" type="button" onclick="location.href='form.jsp' ">Register</button>
      <button id ="login" >Sign in</button>
    </div>
  </form>
</div>

  <script  src="script.js"></script>

</body>
</html>
