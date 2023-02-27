package alex.lu;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//    1) Необходимо создать 2 работника и 1 директора. Для каждого сотрудника распечатать полное имя сотрудника и его з/п.
        System.out.println("=======1=======");
        Worker worker1 = new Worker("Ivan", "Ivanov", 3);
        Worker worker2 = new Worker("Petr", "Petrov", 5);
        List<Employee> employees = new ArrayList<>();
        Director director = new Director("Poligraf", "Sharikov", 10, employees);
        System.out.println(worker1);
        System.out.println(worker2);
        System.out.println(director);
        System.out.println();

//    2) Назначить двух созданных сотрудников под управление директора. Распечатать сведения о директоре (инфо о директоре и об его подчинении).
        System.out.println("=======2=======");
        employees.add(worker1);
        employees.add(worker2);
        System.out.println(director);
        System.out.println();

//    3) Создать нового директора с одним сотрудником (под управлением) и добавить его под управления существующего директора.
        System.out.println("=======3=======");
        List<Employee> employees1 = new ArrayList<>();
        Worker worker3 = new Worker("Sidr", "Sidorov", 7);
        Director director1 = new Director("Mike", "Tyson", 8, employees1);
        director1.addWorker(worker3);
        director.addWorker(director1);
        System.out.println(director1);
        System.out.println();

//    4) Убедиться, что сведения о первом директоре теперь включают сведения о втором, который так же добавлен к нему (и т.д.).
        System.out.println("=======4=======");
        System.out.println(director);

//    5) Создать сервис, который определяет есть ли у данного директора в подчинении (прямом или косвенном) сотрудник с указанным именем (поиск вглубь)
        System.out.println("=======5=======");
        Search search = new Search();
        String search1 = search.search("Sidr", "Sidorov", director);
        System.out.println(search1);
    }
}