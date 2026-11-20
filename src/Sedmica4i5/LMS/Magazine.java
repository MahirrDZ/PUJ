package Sedmica4i5.LMS;

public class Magazine extends LibraryItem{
    private int issueNumber;

    public Magazine(String title, String id,boolean isAvailable,int issueNumber) {
        super(title, id,isAvailable);
        this.issueNumber = issueNumber;
    }

    public int getIssueNumber(){
        return issueNumber;
    }

    @Override
    public void getInfo(){
        System.out.println("Title: " + getTitle() + ", ID: " + getId() +", Available:"+isAvailable+ ", Issue Number: " + getIssueNumber());
    }
}
