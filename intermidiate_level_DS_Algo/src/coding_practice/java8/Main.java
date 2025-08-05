package coding_practice.java8;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Employee> list = getEmployeeList();

        // using comparable
        Collections.sort(list);
        //print(list);

        // using comparator
        Collections.sort(list, new EmployeeNameComparator());
       // print(list);

        Collections.sort(list, new EmployeeAgeComparator());
        //print(list);

        List<Employee> newList = getEmployeeList();
        newList.stream().sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getAge)).forEach(System.out::println);

        Map<String, List<Employee>> collect = newList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println("Employees grouped by department:");
        collect.forEach((department, employees) ->{
            System.out.println(department +": ");
            employees.forEach(System.out::println);
        });

        Map<String, List<String>> collect1 = newList.stream()
                .collect(
                        Collectors
                                .groupingBy(
                                        Employee::getDepartment,
                                        Collectors.mapping(Employee::getName, Collectors.toList())));
        System.out.println("Employees mapped by department:"+ collect1);

    }

    private static void print(List<Employee> list) {
        System.out.println("Printing Employee List:");
        System.out.println("-------------------------");
       list.forEach(employee ->System.out.println(employee));
    }

    private static List<Employee> getEmployeeList() {
        Employee emp1 = new Employee("Alice", 30, 50000, "HR");
        Employee emp2 = new Employee("Bob", 25, 60000, "IT");
        Employee emp3 = new Employee("Charlie", 35, 70000, "Finance");
        Employee emp4 = new Employee("Alice", 20, 40000, "HR");
        Employee emp5 = new Employee("Bob", 20, 20000, "IT");
        Employee emp6 = new Employee("Charlie", 15, 80000, "Marketing");

        List<Employee> list = new ArrayList<>(Arrays.asList(emp1, emp2, emp3, emp4, emp5, emp6));
        return list;
    }
}
