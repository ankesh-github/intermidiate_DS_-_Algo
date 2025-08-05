package coding_practice.java8;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class LambdaExample {
    public static void main(String[] args) {

        //Write a program to filter all even numbers from a list using a lambda expression.
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumber = numbers.stream().filter(number -> number % 2 == 0).collect(Collectors.toList());
        System.out.println(evenNumber);

        // Write a Java 8 program to remove all null and empty strings from a list.
        List<String> strings = Arrays.asList("apple", "", "banana", null, "cherry", "", "date");
        List<String> newStr = strings.stream().filter(s -> s != null && !s.isBlank()).collect(Collectors.toList());
        System.out.println(newStr);


        //Given a list of names, convert them all to uppercase using lambda and print.
        List<String> strList = Arrays.asList("apple", "banana", "cherry", "date");
        strList.stream().map(s -> s.toUpperCase()).forEach(System.out::println);

        //Given a list of integers, write a Java 8 program to find the second highest number.
        List<Integer> intList = Arrays.asList(10, 20, 30, 40, 20, 30, 5, 25, 35);
        Optional<Integer> first = intList.stream().distinct().sorted().skip(1).findFirst();
        System.out.println(first.get());

        //Write a Java 8 program to find the first non-repeated character in a string.
        String str = "swissaafbbswwm";
        char ch = str.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> str.indexOf(c) == str.lastIndexOf(c))
                .findFirst()
                .orElse(null);

        System.out.println(ch);

        //Count strings with length > 5 using streams.
        List<String> stringList = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");
        long count = stringList
                .stream()
                .filter(st -> st.length() > 5)
                .count();
        System.out.println(count);

        // Flatten a list of lists in Java 8 using flatMap.
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("apple", "banana"),
                Arrays.asList("cherry", "date"),
                Arrays.asList("elderberry", "fig")
        );

        List<String> collect = listOfLists.stream().flatMap(Collection::stream).collect(Collectors.toList());
        System.out.print(collect);
        System.out.println();

        //  Group a list of Employee by department name using Collectors.groupingBy.
        List<Employee> employees = getEmployeeList();
        Map<String, List<Employee>> map = employees.stream()
                .collect(Collectors.groupingBy(employee -> employee.getDepartment()));

        System.out.println(map);

        // Find difference in days between two LocalDate values.
        LocalDate startDate = LocalDate.of(2023, 1, 1);
        LocalDate endDate = LocalDate.of(2023, 12, 31);
        System.out.println("startDate: " + startDate+ " endDate: " + endDate);

        long between = ChronoUnit.DAYS.between(startDate, endDate);
        System.out.println(between + " days between " + startDate + " and " + endDate);

        // Get current time in New York using ZoneId.
        ZonedDateTime currentTimeInNY = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println(currentTimeInNY);

        //Convert String yyyy-MM-dd to LocalDate and vice versa.
        String dateString = "2023-10-01";
        LocalDate localDate = LocalDate.parse(dateString);
        System.out.println("LocalDate: " + localDate);

    }

    private static List<Employee> getEmployeeList() {
        Employee emp1 = new Employee("Alice", 30, 50000, "HR");
        Employee emp2 = new Employee("Bob", 25, 60000, "IT");
        Employee emp3 = new Employee("Charlie", 35, 70000, "Finance");
        Employee emp4 = new Employee("Alice1", 20, 40000, "HR");
        Employee emp5 = new Employee("Bob1", 15, 20000, "IT");
        Employee emp6 = new Employee("Charlie1", 45, 80000, "Marketing");

        return Arrays.asList(emp1, emp2, emp3, emp4, emp5, emp6);
    }
}
