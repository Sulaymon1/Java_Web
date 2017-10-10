package servlets;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;

/**
 * Created by Sulaymon on 07.10.2017.
 */
public class CalculatorDBServlet extends HttpServlet {
    private Connection connection;

    @Override
    public void init() throws ServletException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/informatics_hw",
                    "postgres",
                    "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM historymathoperations");
            ResultSet rs = statement.executeQuery();
            String s = "";
            while (rs.next()){
               s +=  rs.getString(3)+String.valueOf(rs.getLong(2)) ;
            }
            System.out.println(s);
            req.setAttribute("mathOperations", s);
            req.getRequestDispatcher("WEB-INF/jsp/mathHistory.jsp").forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
