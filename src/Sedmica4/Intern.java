package Sedmica4;

public class Intern extends Employee{
    private String school;
    private String mentorName;
    private int durationInMonths;

    public Intern(String postion,String name, int id, double salary, String school, String mentorName, int durationInMonths) {
        super(postion,name, id, salary);
        this.school = school;
        this.mentorName = mentorName;
        this.durationInMonths = durationInMonths;
    }

    public String getSchool(){
        return school;
    }
    public int getDurationInMonths(){
        return durationInMonths;
    }
    public String getMentorName(){
        return mentorName;
    }

    @Override
    public void work(){
        System.out.println(getName()+" is working and being mentored by "+mentorName);
    }

    @Override
    public String getDetails(){
        return super.getDetails() + " and attends " + school+" Current duration: "+durationInMonths+" months";
    }

}
