package dailyPractice;

public class ParentClass {
    public ParentClass() {
        System.out.println("Parent Class!");
    }

    private void display() {
        System.out.println("Parent class private method!");
    }

    public static void print() {
        System.out.println("Parent class static method!");
    }

    void defaultMethod() {
        System.out.println("parent Default method!");
    }
}

class ChildClass extends ParentClass {

    ChildClass() {
        System.out.println("Child class!");
    }

    @Override
    public void defaultMethod() {
        System.out.println("child default method!");
    }
}

class main {
    public static void main(String[] args) {

        ParentClass parentClass = new ParentClass();
        parentClass.defaultMethod();
        ParentClass.print();


    }
}
