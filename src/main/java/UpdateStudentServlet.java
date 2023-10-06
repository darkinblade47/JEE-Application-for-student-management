import Database.Database;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id", id);
        ResultSet stud = Database.getInstance().GetStudent(id);
        try {
            request.setAttribute("nume", stud.getString("nume"));
            request.setAttribute("prenume", stud.getString("prenume"));
            request.setAttribute("varsta", stud.getInt("varsta"));
            request.setAttribute("email", stud.getString("email"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("./update-student.jsp").forward(request, response);
    }
}