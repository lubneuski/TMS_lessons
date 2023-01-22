package lu.alex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CarServiceImpl27 implements CarService27{

    StartupServlet27 servlet27 = new StartupServlet27();

    @Override
    public void save(Car27 car27) {
        Connection connection = servlet27.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into car27 (id, brand, model) values (?,?,?)");
            preparedStatement.setString(1, car27.getId());
            preparedStatement.setString(2, car27.getBrand());
            preparedStatement.setString(3, car27.getModel());
            preparedStatement.execute();
        }catch (Exception exc){
            throw new RuntimeException("SQL_add_exc");
        }
    }

    @Override
    public void delete(String id) {
        try {
            Connection connection = servlet27.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from car27 where id = ?");
            preparedStatement.setString(1, id);
            preparedStatement.execute();
        }catch (Exception exc){
            throw new RuntimeException("SQL_delete_exc");
        }
    }

    @Override
    public void update(Car27 car27) {
        try {
            Connection connection = servlet27.getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE car27 SET brand= ?, model= ?" +
                    " WHERE id= ?");
            statement.setString(1, car27.getId());
            statement.setString(2, car27.getBrand());
            statement.setString(3, car27.getModel());
            statement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("SQL_update_exc");
        }
    }

    @Override
    public List<Car27> getAll() {
        List<Car27> car27 = new ArrayList<>();
        try {
            Connection connection = servlet27.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from car27");
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String brand = resultSet.getString("brand");
                String model = resultSet.getString("model");
                car27.add(new Car27(id, brand, model));
            }
        }catch (Exception exc){
            throw new RuntimeException ("SQL_exc");
        }
        return car27;
    }

    @Override
    public List<Car27> getByID(String id) {
        List<Car27> car27 = new ArrayList<>();
        try {
            Connection connection = servlet27.getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from car27 where id = ?");
            statement.setString(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getString("id");
                String brand = resultSet.getString("brand");
                String model = resultSet.getString("model");
                car27.add(new Car27(id, brand, model));
            }
        }catch (Exception exc){
            throw new RuntimeException ("SQL_exc");
        }
        return car27;
    }
}
