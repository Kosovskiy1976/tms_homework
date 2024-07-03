import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(urlPatterns = "/init", loadOnStartup = 1)
public class InitServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute("create table if not exists films (\n" +
                    "                       name varchar,\n" +
                    "                       description varchar,\n" +
                    "                       yearOfRelease int,\n" +
                    "                       viewed boolean,\n" +
                    "                       id uuid primary key\n" +
                    ");");

            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Connection getConnection(){
        try {
            return DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/postgres?user=postgres&password=Ichbin");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
