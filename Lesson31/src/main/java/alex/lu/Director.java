package alex.lu;

import java.util.List;

public class Director extends Employee{

    private final List<Employee> workers;

    public Director(String name, String surname, int experience, List<Employee> workers) {
        super(name, surname, experience);
        this.workers = workers;
        position = Position.DIRECTOR;
    }

    public List<Employee> getWorkers() {
        return workers;
    }

    public void addWorker(Employee employee){
        workers.add(employee);
    }

        @Override
    public int salary() {
        return super.salary() + (workers.size() * 100);
    }

    @Override
    public String toString() {
        return super.toString() +
                ", salary: " + salary() +
                "\n" + "Director's workers: " + workers.size() + "\n" + workers;
    }
}