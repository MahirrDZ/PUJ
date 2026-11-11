package Sedmica4.LMS;

public class Book extends LibraryItem{
    private String author;

    public Book(String title, String id,boolean isAvalible, String author) {
        super(title, id,isAvalible);
        this.author = author;
    }

    public String getAuthor(){
        return author;
    }

    @Override
    public void getInfo(){
        System.out.println("Title "+getTitle()+", ID: "+getId()+", Available:"+isAvailable+", Author: "+getAuthor());
    }
}
