package alex.lu;

public class Worker extends Employee{

    public Worker(String name, String surname, int experience) {
        super(name, surname, experience);
        position = Position.WORKER;
    }

    @Override
    public String toString() {
        return super.toString() + ", salary: " + salary();
    }
}