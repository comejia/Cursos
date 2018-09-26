package clases;

//import android.graphics.drawable.Drawable;

public class Library {
    private String bookName;
    private String subject;
    private String details;

    public Library() {
        super();
    }

    public Library(String bookName, String subject, String details) {
        this.bookName = bookName;
        this.subject = subject;
        this.details = details;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setDetails(String details) { this.subject = details;}

    public String getBookName() {
        return bookName;
    }

    public String getSubject() {
        return subject;
    }

    public String getDetails() {
        return details;
    }
}
