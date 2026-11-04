package Sedmica4;

import java.time.LocalDate;
import java.time.Period;

public class Manager extends Employee {
    private double bonus;
    private LocalDate accuiredMangeementDate;

    public Manager(String position,String name, int id, double salary, double bonus, LocalDate accuiredMangeementDate) {
        super(position,name, id, salary);
        this.bonus = bonus;
        this.accuiredMangeementDate = accuiredMangeementDate;
    }

    public double getBonus(){
        return bonus;
    }

    public LocalDate getAcquiredManagementDate(){
        return accuiredMangeementDate;
    }

    public double getSalaryWithoutBonus(){
        return super.getSalary();
    }

    public int yearsManaging(){
        return Period.between(accuiredMangeementDate, LocalDate.now()).getYears();
    }

    @Override
    public double getSalary(){
        return super.getSalary() + bonus;
    }

    @Override
    public void work(){
        System.out.println(getName() + " is managing the team");
    }

    @Override
    public String getDetails(){
        return super.getDetails() +" Has been managing for "+yearsManaging()+ " years and has bonus " + bonus + " for a Salary total of " + getSalary();
    }
    @Override
    public Employee clone() {

        Manager copy = (Manager) super.clone();
        copy.accuiredMangeementDate = LocalDate.of(accuiredMangeementDate.getYear(),
                accuiredMangeementDate.getMonth(), accuiredMangeementDate.getDayOfMonth());
        return copy;

    }
}
