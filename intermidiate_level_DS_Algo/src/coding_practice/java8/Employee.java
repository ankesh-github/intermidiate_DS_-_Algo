package coding_practice.java8;

// name, age, salary, gender, designation, department
public class Employee {
    private int id;
    private String name;
    private int age;
    private double salary;
    private String department;
    private String gender;
    private String designation;

    public Employee(int id, String name, int age, double salary, String department, String gender, String designation) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
        this.gender = gender;
        this.designation =  designation;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    public String getGender() {
        return gender;
    }

    public String getDesignation() {
        return designation;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                ", gender='" + gender + '\'' +
                ", designation='" + designation + '\'' +
                '}';
    }

}
