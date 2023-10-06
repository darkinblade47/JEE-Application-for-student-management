<%@ page import="java.util.ArrayList" %>
<%@ page import="beans.StudentBean" %>
<html xmlns:jsp="http://java.sun.com/JSP/Page">
<head>
    <title>Informatii studenti cautati</title>
    <h1>Informatii studenti cautati</h1>
</head>
<body>
<%
    ArrayList<StudentBean> lista = (ArrayList<StudentBean>) request.getAttribute("beanList");
    for (StudentBean bean : lista) {
%>
<ul type="bullet">
    <li>ID: <% out.print(bean.getId()); %></li>
    <li>Nume: <% out.print(bean.getNume()); %></li>
    <li>Prenume: <% out.print(bean.getPrenume()); %></li>
    <li>Varsta: <% out.print(bean.getVarsta()); %></li>
    <li>An nastere: <% out.print(bean.getAnNastere()); %></li>
    <li>Email: <% out.print(bean.getEmail()); %></li>
</ul>
<%
    }
%>
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
<a href="/Tema1">Go to home section</a>
<br/>
<a href="/Tema1/read-student">Go to student information section</a>
</body>
</html>