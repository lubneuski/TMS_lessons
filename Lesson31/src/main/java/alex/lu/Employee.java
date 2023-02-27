package alex.lu;

public abstract class Employee {
    private final String name;
    private final String surname;
    private final int experience;
    Position position;

    public Employee(String name, String surname, int experience) {
        this.name = name;
        this.surname = surname;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int salary(){
        return 1000 * position.coef * experience;
    }

    @Override
    public String toString() {
        return  position +
                ": " + name +
                ", " + surname +
                ", experience: " + experience;
    }
}