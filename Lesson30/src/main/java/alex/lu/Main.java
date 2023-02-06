package alex.lu;

public class Main {
    public static void main(String[] args) {

        DataBaseConfig dataBaseConfig = new DataBaseConfig();
        dataBaseConfig.init();

        CarService service = new CacheCarServiceImpl(new CarServiceImpl());

        Car car1 = new Car("1","Toyota", "Avensis");
        Car car2 = new Car("2","Volvo", "S90");
        Car car3 = new Car("3","Geely", "Atlas");

        service.save(car1);
        service.save(car2);
        service.save(car3);

        service.getByID("2");

        service.delete("3");

        service.update(new Car("1", "Lexus", "Ls450"));
        service.getByID("1");


    }
}