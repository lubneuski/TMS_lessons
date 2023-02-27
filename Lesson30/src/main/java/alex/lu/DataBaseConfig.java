package alex.lu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConfig {

    public void init() {
        try {
            Class.forName("org.postgresql.Driver");
            Statement statement = getConnection().createStatement();
            statement.execute("drop table if exists car");
            statement.execute("create table car (" +
                    " id varchar primary key, " +
                    " brand varchar, " +
                    " model varchar)");
        } catch (Exception exc) {
            System.out.println(exc);
            throw new RuntimeException(exc);
        }
    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/car","dell", "123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}