package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {
    private volatile static Database instance = null;
    private int id = 1;
    private Connection con = null;
    private Statement statement = null;

    private Database() {
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:/home/darkinblade/SD/Tema1/student.db");
            statement = con.createStatement();
            this.Create();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

    }

    //Singleton database
    public static Database getInstance() {
        if (instance == null)
            instance = new Database();
        return instance;
    }

    public int getId() {
        return id;
    }

    public void Create() {
        if (con != null) {
            try {
                String StudentDB =
                        "CREATE TABLE IF NOT EXISTS student " +
                                "(id INT PRIMARY KEY NOT NULL, " +
                                "nume TEXT NOT NULL, " +
                                "prenume TEXT NOT NULL, " +
                                "varsta INT NOT NULL, " +
                                "anNastere INT NOT NULL, " +
                                "email TEXT NOT NULL);";
                statement.executeUpdate(StudentDB);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void InsertStudent(String nume, String prenume, int varsta, int anNastere, String email) {
        try {
            String s;
            s = "INSERT INTO student VALUES " +
                    "((select max(id) from student)+1,'" + nume + "','" + prenume + "'," + varsta + "," + anNastere + ",'" + email + "');";
            statement.executeUpdate(s);
            id++;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void UpdateStudent(int id, String nume, String prenume, int varsta, int anNastere, String email) {
        try {
            String s;
            s = "UPDATE student set nume = '" + nume + "',prenume = '" + prenume + "',varsta = "
                    + varsta + ",anNastere=" + anNastere + ",email='" + email + "' where id=" + id + ";";
            statement.executeUpdate(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DeleteStudent(int id) {
        try {
            String s;
            s = "DELETE from student where id = " + id + ";";
            statement.executeUpdate(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet GetIds() {
        try {
            String s = "SELECT id FROM student;";
            return statement.executeQuery(s);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet GetStudent(int id) {
        try {
            String s = "SELECT * FROM student where id= " + id + ";";
            return statement.executeQuery(s);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet GetStudents() {
        try {
            String s = "SELECT * from student";
            return statement.executeQuery(s);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet findStudent(String criteriu, String cautare) {
        try {
            String s = "SELECT * from student where " + criteriu + "='" + cautare + "';)";
            return statement.executeQuery(s);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
