package alex.lu;

public interface CarService {
    void save (Car car);
    void delete(String id);
    void getByID(String id);
    void update(Car car);
}