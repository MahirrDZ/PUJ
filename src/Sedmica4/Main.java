package Sedmica4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("employees.txt"))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] parts = line.split(",");
                String type = parts[0];
                String name = parts[1];
                int id = Integer.parseInt(parts[2]);
                double salary = Double.parseDouble(parts[3]);

                if (type.equals("EMPLOYEE")) {
                    employees.add(new Employee("EMPLOYEE",name, id, salary));
                } else if (type.equals("MANAGER")) {
                    double bonus = Double.parseDouble(parts[4]);
                    LocalDate date = LocalDate.parse(parts[5]);
                    employees.add(new Manager("MANAGER",name, id, salary, bonus,date));
                } else if (type.equals("INTERN")) {
                    String school = parts[4];
                    String mentor = parts[5];
                    int durationInMonths = Integer.parseInt(parts[6]);
                    employees.add(new Intern("INTERN",name, id, salary, school, mentor, durationInMonths));
                }
            }
        } catch (IOException e) {
            System.out.println("Greska u čitanju file-a " + e.getMessage());
        }

        System.out.println("---------------------------------------------------------");

        for (Employee e : employees) {
            System.out.println(e.getDetails());
            e.work();
        }

        System.out.println("---------------------------------------------------------");
        System.out.println("Total salary for all employees " + getTotalSalaryRounded(employees));
        System.out.println("---------------------------------------------------------");

        System.out.println("Sorted employees by salary ");
        ArrayList<Employee>employeesSorted=Sorter(employees);
        for (Employee e : employeesSorted) {
            System.out.println(e.getDetails());
        }
        System.out.println("---------------------------------------------------------");

        System.out.println("Top employee by salary ");
        System.out.println(employeesSorted.getFirst().getDetails());
        System.out.println("---------------------------------------------------------");
        writeToFile(employeesSorted,"employeesSorted.txt");
        System.out.println("Employee list saved in employeesSorted.txt");
        System.out.println("---------------------------------------------------------");
        System.out.println("Cloning example: ");
        Employee original=employees.getFirst();
        Employee clone=original.clone();
        System.out.println(original.getDetails());
        System.out.println(clone.getDetails());
        System.out.println("---------------------------------------------------------");
        System.out.println("Pretraga:");
        pretrazi(employeesSorted);



    }

    public static int getTotalSalaryRounded(ArrayList<Employee> employees) {

        double totalSalary = 0;

        if (employees.isEmpty()) {
            throw new IllegalArgumentException("Employee list is empty");
        } else {
            for (Employee e : employees) {
                totalSalary += e.getSalary();
            }
        }

        return (int) Math.round(totalSalary);

    }

    public static ArrayList<Employee> Sorter(ArrayList<Employee> employees) {

        if (employees.isEmpty()) {
            throw new IllegalArgumentException("Employee list is empty");
        } else {
            ArrayList<Employee> employeesSorted = new ArrayList<>(employees);
            Collections.sort(employeesSorted);
            return employeesSorted;
        }
    }

    public static void writeToFile(ArrayList<Employee> employees,String fileName) {

        try (FileWriter fw = new FileWriter(fileName)) {
            for (Employee e : employees) {
                switch(e.getClass().getSimpleName()){
                    case "Employee":
                        fw.write(e.getPosition()+","+e.getName()+","+e.getId()+","+e.getSalary()+"\n");
                        break;
                    case "Manager":
                        Manager m = (Manager) e;
                        fw.write(m.getPosition()+","+m.getName()+","+m.getId()+","+m.getSalaryWithoutBonus()+","+m.getBonus()+","+m.getAcquiredManagementDate()+"\n");
                        break;
                    case "Intern":
                        Intern i = (Intern) e;
                        fw.write(i.getPosition()+","+i.getName()+","+i.getId()+","+i.getSalary()+","+i.getSchool()+","+i.getMentorName()+","+i.getDurationInMonths()+"\n");
                        break;
                    default:
                        System.out.println("Nepoznata klasa: "+e.getClass().getSimpleName());
                }
            }
        } catch (IOException e) {
            System.out.println("Greska u pisanju file-a " + e.getMessage());
        }
    }

    public static void pretrazi(ArrayList<Employee> employees){
        System.out.println("Po čemu zelite pretraziti");
        System.out.println("1. Pretraga po imenu");
        System.out.println("2. Pretraga po id");
        System.out.println("Unesite opciju:");
        Scanner sc = new Scanner(System.in);
        boolean found=false;
        switch(sc.nextInt()){
            case 1:
                System.out.println("Unesite ime");
                sc.nextLine();
                String ime = sc.nextLine();
                for (Employee e : employees) {
                    if(e.getName().toLowerCase().contains(ime.toLowerCase())){
                        found=true;
                        System.out.println("Employee found: ");
                        System.out.println(e.getDetails());
                        System.out.println("---------------------------------------------------------");
                    }else{
                        found=false;
                    }
                }
                if(!found){
                    System.out.println("Employee not found");
                }
                break;
            case 2:
                found=false;
                System.out.println("Unesite id");
                int id = sc.nextInt();
                for (Employee e : employees) {
                    if(e.getId()==id){
                        found=true;
                        System.out.println("Employee found: ");
                        System.out.println(e.getDetails());
                        System.out.println("---------------------------------------------------------");
                    }else{
                        found=false;
                    }
                }
                if(!found){
                    System.out.println("Employee not found");
                }
                break;
            default:
                System.out.println("Neispravan unos");
        }

    }
}

