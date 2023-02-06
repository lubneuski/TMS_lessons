package alex.lu;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CacheCarServiceImpl implements CarService {

    List<Car> carsCache = new ArrayList<>();

    private final CarService service;

    public CacheCarServiceImpl(CarService service) {
        this.service = service;
    }

    @Override
    public void save(Car car) {
        if (carsCache.contains(car)){
            System.out.println("Tha Car already exist.");
        } else {
            service.save(car);
            carsCache.add(car);
            System.out.println("The Car " + car + " successfully saved in cache");
        }
    }

    @Override
    public void delete(String id) {
        Optional<Car> first = carsCache.stream().filter(c -> c.getId().equals(id)).findFirst();
        service.delete(id);
        carsCache.remove(first);
        System.out.println("The Car was deleted from cache.");
    }

    @Override
    public void getByID(String id) {
        Optional<Car> first = carsCache.stream().filter(c -> c.getId().equals(id)).findFirst();
        System.out.println("The Car from cache: " + first);
    }

    @Override
    public void update(Car car) {
        boolean b = carsCache.removeIf(c -> c.getId().equals(car.getId()));
        carsCache.add(car);
        service.update(car);
        System.out.println("The Car was updated in cache.");
    }

}