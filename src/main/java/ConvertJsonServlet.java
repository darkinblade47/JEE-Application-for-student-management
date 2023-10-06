import Database.Database;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConvertJsonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        ResultSet rez = Database.getInstance().GetStudents();
        JSONObject db = new JSONObject();
        JSONArray dbArray = new JSONArray();
        try {
            while (rez.next()) {
                JSONObject inregistrare = new JSONObject();
                inregistrare.put("id", rez.getInt("id"));
                inregistrare.put("nume", rez.getString("nume"));
                inregistrare.put("prenume", rez.getString("prenume"));
                inregistrare.put("varsta", rez.getInt("varsta"));
                inregistrare.put("anNastere", rez.getInt("anNastere"));
                inregistrare.put("email", rez.getString("email"));
                dbArray.add(inregistrare);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.put("student", dbArray);

        try {
            FileWriter file = new FileWriter("/home/darkinblade/SD/Tema1/student.json");
            file.write(db.toJSONString());
            file.close();
            request.setAttribute("status", "succes");
        } catch (IOException e) {
            e.printStackTrace();
            request.setAttribute("status", "esuat");
        }

        request.getRequestDispatcher("./convert-status.jsp").forward(request, response);

    }

}