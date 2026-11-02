package Sedmica3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Employee> employees = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader("employees.txt"))) {
            String line;
            while((line = br.readLine()) != null){
                String[] parts= line.split(",");
                String type=parts[0];
                String name=parts[1];
                int id=Integer.parseInt(parts[2]);
                double salary=Double.parseDouble(parts[3]);

                if(type.equals("EMPLOYEE")){
                    employees.add(new Employee(name,id,salary));
                }else if(type.equals("MANAGER")){
                    double bonus=Double.parseDouble(parts[4]);
                    employees.add(new Manager(name,id,salary,bonus));
                }

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        for(Employee e:employees){
            e.work();
            System.out.println(e.getDetails());
        }

    }
}
