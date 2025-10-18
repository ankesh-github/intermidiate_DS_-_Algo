package dailyPractice;
import java.time.LocalDate;
import java.util.*;

public class Person {
    String name;
    LocalDate dob;

    public Person(String name, LocalDate dob) {
        this.name = name;
        this.dob = dob;
    }

    @Override
    public String toString() {
        return name + " (" + dob + ")";
    }
}

 class BirthdayFilter {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Ankesh", LocalDate.of(1995, 9, 14)),
                new Person("Rahul", LocalDate.of(1990, 3, 21)),
                new Person("Priya", LocalDate.of(1998, 9, 27)),
                new Person("Sneha", LocalDate.of(1992, 12, 5))
        );

        int searchMonth = 9; // September (1 = Jan, 12 = Dec)

        System.out.println("People with birthdays in month " + searchMonth + ":");
        people.stream()
                .filter(p -> p.dob.getMonthValue() == searchMonth)
                .forEach(System.out::println);
    }
}

