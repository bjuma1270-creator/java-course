package week7;

public class ProtectedAccessDemo {

    public static void main(String[] args) {
        Manager manager = new Manager("John", 50000);
        manager.printNameDirectly();
    }
}

class Employee {
    protected String name;
    protected double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }
}

class Manager extends Employee {

    public Manager(String name, double baseSalary) {
        super(name, baseSalary);
    }

    public void printNameDirectly() {
        System.out.println("Direct access to name: " + name);
    }
}
