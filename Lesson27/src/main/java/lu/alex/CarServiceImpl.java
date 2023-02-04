package lu.alex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CarServiceImpl implements CarService{

    StartupServlet servlet = new StartupServlet();

    @Override
    public void save(Car car) {
        Connection connection = servlet.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into car (id, brand, model) values (?,?,?)");
            preparedStatement.setString(1, car.getId());
            preparedStatement.setString(2, car.getBrand());
            preparedStatement.setString(3, car.getModel());
            preparedStatement.execute();
        }catch (Exception exc){
            throw new RuntimeException("SQL_add_exc");
        }
    }

    @Override
    public void delete(String id) {
        try {
            Connection connection = servlet.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from car where id = ?");
            preparedStatement.setString(1, id);
            preparedStatement.execute();
        }catch (Exception exc){
            throw new RuntimeException("SQL_delete_exc");
        }
    }

    @Override
    public void update(Car car) {
        try {
            Connection connection = servlet.getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE car SET brand = ?, model = ?" +
                    " WHERE id= ?");
            statement.setString(1, car.getId());
            statement.setString(2, car.getBrand());
            statement.setString(3, car.getModel());
            statement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("SQL_update_exc");
        }
    }

    @Override
    public List<Car> getAll() {
        List<Car> car = new ArrayList<>();
        try {
            Connection connection = servlet.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from car");
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String brand = resultSet.getString("brand");
                String model = resultSet.getString("model");
                car.add(new Car(id, brand, model));
            }
        }catch (Exception exc){
            throw new RuntimeException ("SQL_exc");
        }
        return car;
    }

    @Override
    public List<Car> getByID(String id) {
        List<Car> car = new ArrayList<>();
        try {
            Connection connection = servlet.getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from car where id = ?");
            statement.setString(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getString("id");
                String brand = resultSet.getString("brand");
                String model = resultSet.getString("model");
                car.add(new Car(id, brand, model));
            }
        }catch (Exception exc){
            throw new RuntimeException ("SQL_exc");
        }
        return car;
    }
}
