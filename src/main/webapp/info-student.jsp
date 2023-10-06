<%@ page import="Database.Database" %>
<%@ page import="java.sql.ResultSet" %>
<html xmlns:jsp="http://java.sun.com/JSP/Page">
<head>
    <title>Informatii student</title>
    <h3>Cautare dupa nume/prenume/email:</h3>
    <br/>
    <form action="./find-student" method="get">
        <input type="radio" id="nume" name="criteriu" value="nume">
        <label for="nume">Nume</label><br>
        <input type="radio" id="prenume" name="criteriu" value="prenume">
        <label for="prenume">Prenume</label><br>
        <input type="radio" id="email" name="criteriu" value="email">
        <label for="email">Email</label><br/>
        Cautare:<input type="text" name="cautare"/><br/>
        <button type="submit" name="submit">Cauta</button>
    </form>
    <br/><br/>
    <h3>Actualizare/Stergere studenti</h3>
    Actualizare:
    <form action="./update-student" method="get">
        <input type="number" name="id"/>
        <button type="submit" name="submit">To update</button>
    </form>
    Delete:
    <form action="./delete-student" method="get">
        <input type="number" name="id"/>
        <button type="submit" name="submit">To delete</button>
    </form>
</head>
<body>
<h3>Informatii student</h3>
<%
    ResultSet students = Database.getInstance().GetStudents();
    while (students.next()) {
%>
<ul type="bullet">
    <li>ID: <% out.print(students.getInt("id")); %></li>
    <li>Nume: <% out.print(students.getString("nume")); %></li>
    <li>Prenume: <% out.print(students.getString("prenume")); %></li>
    <li>Varsta: <% out.print(students.getString("varsta")); %></li>
    <li>An nastere: <% out.print(students.getString("anNastere")); %></li>
    <li>Email: <% out.print(students.getString("email")); %></li>
</ul>
<%
    }
%>
<a href="./">Go to home section</a>
<br/>
<a href="./read-student">Go to student information section</a>
<br/>
<form action="./convert-status" method="get">
    <button type="submit" name="submit">Conversie db to json</button>
</form>
</body>
</html>