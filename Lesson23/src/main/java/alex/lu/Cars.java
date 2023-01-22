package alex.lu;

public class Cars {

    private String car;
    private String model;

    public Cars(String car, String model) {
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