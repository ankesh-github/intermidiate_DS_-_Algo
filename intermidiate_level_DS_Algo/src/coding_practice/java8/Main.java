package coding_practice.java8;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static final String SOFTWARE_ENGINEER = "Software Engineer";
    private static final String S_SOFTWARE_ENGINEER = "Senior Software Engineer";
    private static final String MANAGER = "Manager";
    private static final String INTERN = "Intern";
    private static final String PRODUCT_OWNER = "Product Owner";

    private static final String IT = "IT";
    private static final String HR = "HR";
    private static final String MANAGEMENT = "Management";

    private static final String MALE = "Male";
    private static final String FEMALE = "Female";



    public static void main(String[] args) {
        List<Employee> list = getEmployeeList();
        //list.forEach(e-> System.out.println(e));

        //Find the 5 eldest employees in the company
        List<Employee> sortedList = list.stream().distinct()
                .sorted(Comparator.comparing(Employee::getAge).reversed()).limit(5).collect(Collectors.toList());
        //sortedList.forEach(System.out::println);

        //Find the highest salaried employee
        Optional<Employee> max = list.stream().distinct().max(Comparator.comparing(Employee::getSalary));
        //System.out.println(max.get());
        
        //* Display the number of males & females in company
        Map<String, List<Employee>> collect = list.stream().collect(Collectors.groupingBy(Employee::getGender));
        System.out.println(collect);

        // * Find out the expense department wise
        Map<String, Double> collect1 = list.stream().collect(Collectors.
                groupingBy(Employee::getDepartment, Collectors.summingDouble(Employee::getSalary)));
        //System.out.println(collect1);

        //* Find the youngest employee designation wise
        Map<String, Optional<Employee>> collect2 = list.stream().collect(Collectors.groupingBy(Employee::getDesignation,
                Collectors.minBy(Comparator.comparing(Employee::getAge))));
        System.out.println(collect2);

        //* Total number of employees
        long count = list.size();
        System.out.println(count);


    }

    private static List<Employee> getEmployeeList() {
        Employee emp1 = new Employee(1,"Alice", 30, 50000, HR, MALE, INTERN);
        Employee emp2 = new Employee(2,"Bob", 25, 60000, IT, MALE,SOFTWARE_ENGINEER);
        Employee emp3 = new Employee(3,"Charlie", 35, 70000, IT,MALE,SOFTWARE_ENGINEER);
        Employee emp4 = new Employee(4,"Alice", 46, 40000, HR,FEMALE,MANAGER);
        Employee emp5 = new Employee(5,"Seema", 20, 20000, IT,FEMALE,S_SOFTWARE_ENGINEER);
        Employee emp6 = new Employee(6,"Shreya", 75, 80000, MANAGEMENT,FEMALE,PRODUCT_OWNER);

        Employee emp7 = new Employee(1,"Shyam", 40, 90000, HR, MALE, MANAGER);
        Employee emp8 = new Employee(2,"Dany", 45, 60000, IT, FEMALE,SOFTWARE_ENGINEER);
        Employee emp9 = new Employee(3,"Jacky", 55, 70000, IT,FEMALE,INTERN);
        Employee emp10 = new Employee(4,"Alice", 60, 40000, HR,FEMALE,MANAGER);
        Employee emp11 = new Employee(5,"Seema", 33, 20000, IT,FEMALE,S_SOFTWARE_ENGINEER);
        Employee emp12 = new Employee(6,"Shreya", 55, 80000, MANAGEMENT,FEMALE,PRODUCT_OWNER);


        List<Employee> list = new ArrayList<>(Arrays.asList(emp1, emp2, emp3, emp4, emp5, emp6,emp7, emp8, emp9, emp10, emp11, emp12));
        return list;
    }
}
