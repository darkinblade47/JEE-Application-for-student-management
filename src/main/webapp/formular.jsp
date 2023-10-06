<html xmlns:jsp="http://java.sun.com/JSP/Page">
<head>
    <title>Formular student</title>
    <meta charset="UTF-8">
</head>
<body>
<h3>Formular student</h3>
Adaugati un nou student:
<form action="./process-student" method="post">
    Nume: <input type="text" name="nume"/>
    <br/>
    Prenume: <input type="text" name="prenume"/>
    <br/>
    Varsta: <input type="number" name="varsta"/>
    <br/>
    Email: <input type="email" name="email"/>
    <input type="hidden" name="op" value="insert">
    <br/>
    <br/>
    <button type="submit" name="submit">Adauga</button>
</form>
<a href="./">Go to home section</a>
<br/>
<a href="./read-student">Go to student information section</a>
</body>
</html>