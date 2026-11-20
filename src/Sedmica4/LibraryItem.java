package Sedmica4;

public class LibraryItem {
    private String title;
    private String id;
    boolean isAvailable = true;

    public LibraryItem(String title, String id,boolean isAvailable) {
        this.title = title;
        this.id = id;
        this.isAvailable = isAvailable;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }
    public String getIsAvailable(){
        if(isAvailable){
            return "AVAILABLE";
        }else{
            return "UNAVAILABLE";
        }
    }
    public void getInfo(){
        System.out.println("Title: " + title + " ID: " + id + " Available: " + isAvailable);
    }

    public boolean borrow(){
        return isAvailable=false;
    }
    public boolean returnItem(){
        return isAvailable=true;
    }
}
