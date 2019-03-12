    <%-- 
    Document   : login
    Created on : 6 déc. 2018, 12:12:14
    Author     : Hicham
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link rel="stylesheet" type="text/css" href="./style.css">
    </head>
    <body style="background: #eee url(http://subtlepatterns.com/patterns/sativa.png);">
    <div class="container">
    <div class="login-container">
        <div id="output"></div>

               <img src="logo.png"> 

        <div class="form-box">
            <form action="login.et" method="POST">
                <label>Matricule</label>
                <hr>
                <input name="matricule" type="text" placeholder="" required="required">
                <label>Password</label>
                <hr>
                <input name ="pw" type="password" placeholder="" required="required">
                <button class="btn btn-primary btn-block login" type="submit">Login</button>
            </form>
        </div>
    </div>
        
</div>
</body>
</html>
