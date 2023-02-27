package alex.lu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CarServiceImpl implements CarService {

    DataBaseConfig dataBaseConfig = new DataBaseConfig();

    @Override
    public void save(Car car) {
        Connection connection = dataBaseConfig.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into car (id, brand, model) values (?,?,?)");
            preparedStatement.setString(1, car.getId());
            preparedStatement.setString(2, car.getBrand());
            preparedStatement.setString(3, car.getModel());
            preparedStatement.execute();
            System.out.println("The Car " + car + " successfully saved in DataBase");
        }catch (Exception exc){
            throw new RuntimeException("SQL_add_exc");
        }
    }

    @Override
    public void delete(String id) {
        try {
            Connection connection = dataBaseConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from car where id = ?");
            preparedStatement.setString(1, id);
            preparedStatement.execute();
            System.out.println("The Car successfully deleted from DataBase");
        }catch (Exception exc){
            throw new RuntimeException("SQL_delete_exc");
        }
    }

    @Override
    public void getByID(String id) {
        Car car = new Car();
        try {
            Connection connection = dataBaseConfig.getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from car where id = ?");
            statement.setString(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getString("id");
                String brand = resultSet.getString("brand");
                String model = resultSet.getString("model");
                car = new Car(id, brand, model);
            }
            System.out.println("The Car from DataBase: " + car);
        }catch (Exception exc){
            throw new RuntimeException ("SQL_exc");
        }
    }

    @Override
    public void update(Car car) {
        try {
            Connection connection = dataBaseConfig.getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE car SET brand = ?, model = ?" +
                    " WHERE id= ?");
            statement.setString(3, car.getId());
            statement.setString(1, car.getBrand());
            statement.setString(2, car.getModel());
            statement.executeUpdate();
            System.out.println("The Car from DataBase was updated.");
        } catch (Exception e) {
            throw new RuntimeException("SQL_update_exc");
        }
    }

}