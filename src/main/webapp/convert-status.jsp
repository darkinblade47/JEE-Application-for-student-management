<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.FileReader" %>
<html xmlns:jsp="http://java.sun.com/JSP/Page">
<head>
    <title>Status conversie DB->JSON</title>
</head>
<body>
<h3>Status conversie DB->JSON</h3>
<%
    if (request.getAttribute("status") == "succes") {
%>
<h2>Conversie executata cu succes, continutul fisierului json este:</h2>
<%
    BufferedReader br = new BufferedReader(new FileReader("/home/darkinblade/SD/Tema1/student.json"));
    String line;
    while ((line = br.readLine()) != null) {
        out.print(line);
    }
} else {
%>
<h2>CONVERSIE ESUATA, MAI INCEARCA O DATA</h2>
<%
    }
%>
<br/>
<a href="./">Go to home section</a>
<br/>
<a href="./read-student">Go to student information section</a>
</body>
</html>