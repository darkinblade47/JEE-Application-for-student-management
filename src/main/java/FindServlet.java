import Database.Database;
import beans.StudentBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FindServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {// deserializare student din fisierul XML de pe disc
        String criteriu = request.getParameter("criteriu");
        String cautare = request.getParameter("cautare");
        ArrayList<StudentBean> lista = new ArrayList<>();
        StudentBean bean;
        ResultSet rez = Database.getInstance().findStudent(criteriu, cautare);
        try {
            while (rez.next()) {
                bean = new StudentBean();
                bean.setId(rez.getInt("id"));
                bean.setNume(rez.getString("nume"));
                bean.setPrenume(rez.getString("prenume"));
                bean.setVarsta(rez.getInt("varsta"));
                bean.setAnNastere(rez.getInt("anNastere"));
                bean.setEmail(rez.getString("email"));
                lista.add(bean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("beanList", lista);

        request.getRequestDispatcher("./find-student.jsp").forward(request, response);
    }

}