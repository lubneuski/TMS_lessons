package alex.lu;

import java.util.Optional;

public class Search {

    public String search(String name, String surname, Director director){

        Optional<Employee> optionalEmployee = director.getWorkers().stream().filter(employee -> employee.getName().equals(name) && employee.getSurname().equals(surname)).findFirst();
        if (optionalEmployee.isPresent()){
            return "was found";
        } else {
            for (Employee employee : director.getWorkers()){
                if (employee instanceof Director){
                    return search(name, surname, (Director) employee);
                }
            }
            return "not found";
        }
    }
}