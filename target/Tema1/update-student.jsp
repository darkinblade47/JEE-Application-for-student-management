<html xmlns:jsp="http://java.sun.com/JSP/Page">
   <head>
      <title>Actualizare student</title>
   </head>
   <body>
      <h3>Actualizare student</h3>
      <ul type="bullet">
         <form action="./process-student" method="post">
            <li>Nume:<input type="text" name="nume" value=<%=request.getAttribute("nume") %>> </li>
            <li>Prenume:<input type="text" name="prenume" value=<%=request.getAttribute("prenume") %>> </li>
            <li>Varsta:<input type="text" name="varsta" value=<%=request.getAttribute("varsta") %>> </li>
            <li>Email:<input type="text" name="email" value=<%=request.getAttribute("email") %>> </li>
            <input type="hidden" name="op" value="update">
            <input type="hidden" name="id" value=<%=request.getAttribute("id") %>>
            <button type="submit" name="submit">Actualizeaza</button>
         </form>
      </ul>
      <br />
      <a href="./">Go to home section</a>
      <br />
      <a href="./read-student">Go to student information section</a>
   </body>
</html>