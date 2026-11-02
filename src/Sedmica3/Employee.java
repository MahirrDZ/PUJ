package Sedmica3;

public class Employee {
    private String name;
    private int id;
    private double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    public void work(){
        System.out.println("Employee " + name + " is working.");
    }
    public String getDetails(){
        return "Employee " + name + " has id " + id + " and salary " + salary;
    }
}
