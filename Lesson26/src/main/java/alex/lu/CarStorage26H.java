package alex.lu;

import java.util.HashMap;
import java.util.Map;

public class CarStorage26H {
    private static Map<String, Cars26H> cars = new HashMap<>();

    static {
        cars.put("1", new Cars26H("Volvo","S90"));
        cars.put("2", new Cars26H("Toyota","Avensis"));
        cars.put("3", new Cars26H("Geely","Atlas"));
    }

    public static Map<String, Cars26H> getCars() {
        return cars;
    }
}