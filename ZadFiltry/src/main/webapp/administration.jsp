<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Administracja</title>
</head>
<body>
<form action="addpremium" method="POST">
    <label>Podaj nowego uzytkownika premium: <input type="text" id="username" name="username" required/></label><br>
    <label><input type="radio" name="premium" value="add"/> Nadaj prawnienia premium</label><br>
    <label><input type="radio" name="premium" value="delete" checked/> Usun uprawnienia premium</label><br>
    <input type="submit" value="add"/>
</form>
</body>
</html>
