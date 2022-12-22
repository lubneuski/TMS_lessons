package alex.lu;

public class CarList {

    private String car;
    private String model;

    public CarList(String car, String model) {
        this.car = car;
        this.model = model;
    }

    @Override
    public String toString() {
        return " " +
                "car='" + car + '\'' +
                ", model='" + model + '\'';
    }
}