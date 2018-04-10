<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rejestracja</title>
</head>
<body>
<form action="registration" method="POST">
    <label>Login: <input type="text" id="username" name="username" required/></label><br>
    <label>Haslo: <input type="password" id="password" name="password" required/></label><br>
    <label>Powtorz haslo: <input type="password" id="confirmpassword" name="confirmpassword" required/></label><br>
    <label>Adres email: <input type="email" id="email" name="email" required/></label><br>
    <input type="submit" value="zarejestruj"/>
</form>

</body>
</html>
