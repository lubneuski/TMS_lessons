package alex.lu;

public class Cars {
    private String brand;
    private String model;

    public Cars() {
    }

    public Cars(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return " " +
                "brand:'" + brand + '\'' +
                ", model:'" + model + '\'';
    }
}
