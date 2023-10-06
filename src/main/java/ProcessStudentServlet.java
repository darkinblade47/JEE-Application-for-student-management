import Database.Database;
import beans.StudentBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Year;
import java.util.Objects;

public class ProcessStudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        String nume = request.getParameter("nume");
        String prenume = request.getParameter("prenume");
        String email = request.getParameter("email");
        int varsta = Integer.parseInt(request.getParameter("varsta"));
        int anCurent = Year.now().getValue();
        int anNastere = anCurent - varsta;

        StudentBean bean = new StudentBean();
        bean.setNume(nume);
        bean.setPrenume(prenume);
        bean.setVarsta(varsta);
        bean.setAnNastere(anNastere);
        bean.setEmail(email);

        if (Objects.equals(request.getParameter("op"), "update")) {
            Database.getInstance().UpdateStudent(Integer.parseInt(request.getParameter("id")), nume, prenume, varsta, anNastere, email);
            request.getRequestDispatcher("./info-student.jsp").forward(request, response);

        } else if (Objects.equals(request.getParameter("op"), "insert")) {
            Database.getInstance().InsertStudent(nume, prenume, varsta, anNastere, email);
            request.getRequestDispatcher("./formular.jsp").forward(request, response);

        }
    }
}