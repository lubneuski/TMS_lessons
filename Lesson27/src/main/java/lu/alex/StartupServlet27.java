package lu.alex;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


@WebServlet(value = "/init", loadOnStartup = 1)
public class StartupServlet27 extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        try {
            Class.forName("org.postgresql.Driver");
            Statement statement = getConnection().createStatement();
            statement.execute("drop table if exists car27");
            statement.execute("create table car27 (" +
                    " id varchar primary key, " +
                    " brand varchar, " +
                    " model varchar)");
            statement.executeUpdate("insert into car27 " + "values (1, 'Toyota', 'Avensis')");
            statement.executeUpdate("insert into car27 " + "values (2, 'Volvo', 'S90')");
            statement.executeUpdate("insert into car27 " + "values (3, 'Geely', 'Atlas')");
        } catch (Exception exc) {
            System.out.println(exc);
            throw new RuntimeException(exc);
        }
    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/car27","dell", "123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
