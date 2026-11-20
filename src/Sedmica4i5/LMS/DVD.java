package Sedmica4i5.LMS;

public class DVD extends LibraryItem{
    private String director;
    private int durationinMinutes;

    public DVD(String title, String id,boolean isAvailable, String director, int durationinMinutes) {
        super(title, id,isAvailable);
        this.director = director;
        this.durationinMinutes = durationinMinutes;
    }

    public String getDirector(){
        return director;
    }
    public int getDurationinMinutes(){
        return durationinMinutes;
    }

    @Override
    public void getInfo(){
        System.out.println("Title: " + getTitle() + ", ID: " + getId() +", Available:"+isAvailable+ ", Director: " + getDirector() + ", Duration: " + getDurationinMinutes());
    }
}
