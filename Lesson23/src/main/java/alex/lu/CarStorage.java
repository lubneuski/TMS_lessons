package alex.lu;

import java.util.HashMap;
import java.util.Map;

public class CarStorage {
    private static Map<String, Cars> cars = new HashMap<>();

    static {
        cars.put("1", new Cars("Volvo","S90"));
        cars.put("2", new Cars("Toyota","Avensis"));
        cars.put("3", new Cars("Geely","Atlas"));
    }

    public static Map<String, Cars> getCars() {
        return cars;
    }

    public static void setCars(Map<String, Cars> cars) {
        CarStorage.cars = cars;
    }
}