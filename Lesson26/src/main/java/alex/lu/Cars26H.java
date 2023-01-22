package alex.lu;

public class Cars26H {
    private String brand;
    private String model;

    public Cars26H() {
    }

    public Cars26H(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    @Override
    public String toString() {
        return " " +
                "brand:'" + brand + '\'' +
                ", model:'" + model + '\'';
    }
}