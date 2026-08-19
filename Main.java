class Employee {
    String name;
    int id;
    double salary;

    void displayEmployee() {
        System.out.println("Employee ID     : " + id);
        System.out.println("Employee Name   : " + name);
        System.out.println("Salary          : " + salary);
    }
}

class Manager extends Employee {
    String department;

    void displayManager() {
        displayEmployee();
        System.out.println("Department      : " + department);
    }
}

public class Main {
    public static void main(String[] args) {

        Manager m = new Manager();

        m.id = 101;
        m.name = "Rahul";
        m.salary = 50000;
        m.department = "Computer Science";

        System.out.println("----- Employee Details -----");
        m.displayManager();
    }
}
