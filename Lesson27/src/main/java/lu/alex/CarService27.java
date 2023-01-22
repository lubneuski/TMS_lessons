package lu.alex;

import java.util.List;

public interface CarService27 {

    void save (Car27 car27);

    void delete(String id);

    void update(Car27 car27);

    List<Car27>getAll();

    List<Car27>getByID(String id);
}
