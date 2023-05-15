package lesson2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        List<Employee> list2 = new ArrayList<>();
        Employee emp1 = new Employee(100, "Zaur", "Tregulov", 12345);
        Employee emp2 = new Employee(15, "Ivan", "Petrov", 6542);
        Employee emp3 = new Employee(123, "Ivan", "Pedorov", 8542);
        list2.add(emp1);
        list2.add(emp2);
        list2.add(emp3);

        System.out.println("pered sortirovkoy\n" + list2);
        Collections.sort(list2, new idComparator());
        System.out.println("Posle sorting");
        list2.forEach(System.out::println);
        System.out.println("++++++++++++++++++++");
        Collections.sort(list2, new nameComparator());
        list2.forEach(System.out::println);

        System.out.println("++++++++++++++++++++");
        Collections.sort(list2, new salaryComparator());
        list2.forEach(System.out::println);


    }
}

class Employee {
    int id;
    String name;
    String surname;
    int salary;

    public Employee(int id, String name, String surname, int salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                '}';
    }

//    @Override
//    public int compareTo(Employee anotherEmp) {
//        if (this.id == anotherEmp.id) {
//            return 0;
//        } else if (this.id < anotherEmp.id) {
//            return -1;
//        } else
//            return 1;
//    }
    //int res = this.name.compareTo(anotherEmp.name);
    ////return this.name.compareTo(anotherEmp.name);
    //if (res == 0) {
    //    res = this.surname.compareTo(anotherEmp.surname);
    //}
    //return res;

}

class idComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee emp1, Employee emp2) {
        if (emp1.id == emp2.id) {
            return 0;
        } else if (emp1.id < emp2.id) {
            return -1;
        } else
            return 1;
    }
}

class nameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee emp1, Employee emp2) {
        int res = emp1.name.compareTo(emp2.name);
        if (res == 0) {
            res = emp1.surname.compareTo(emp2.surname);
        }
        return res;
    }
}

class salaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee emp1, Employee emp2) {
        return emp1.salary - emp2.salary;
    }
}



