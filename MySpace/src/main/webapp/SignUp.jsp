<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
<title>MyFileSpaceSignUp</title>
<h1> Fill the below from for SignUp.</h1>
<body background="https://www.wallpaperup.com/uploads/wallpapers/2015/10/30/826741/6a0e364fbe723ec85b32f1a68c85b4f9-1400.jpg">
<style>
.button {
    background-color: #f44336; 
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
}
</style>
      <center><form class="signupform" action="RegistrationServlet" method="post">
      Firstname:<input type="text" placeholder="firstname"  name="firstname"  required/></br></br>
      Lastname:<input type="text" placeholder="lastname"  name="lastname"  required/></br></br> 
      Username:<input type="text" placeholder="username"  name="username"  required/></br></br>
      Password:<input type="password" placeholder="password" name="password"  required/></br></br>
      <tr>
      </br><button>SignUp</button>  
<p class="message">Already have an account <a href="Login.jsp">Login</a></p>	  
      
    </form></center>
    </body>
    </html>
    
