/**
 * Created by seandunn92 on 4/25/17.
 */
public class Book {
    private String title;
    private String author;

    public enum STATUS {ONSHELF, CHECKEDOUT};

    private String dueDate;
    private STATUS bookStatus = STATUS.ONSHELF;


    @Override
    public String toString() {
        return title + "," + author + "," + dueDate + "," + bookStatus;
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.dueDate = "None";
        bookStatus = STATUS.ONSHELF;
    }

    public Book(String title, String author, String dueDate) {
        this.title = title;
        this.author = author;
        this.dueDate = dueDate;
        bookStatus = STATUS.ONSHELF;
    }

    public Book(String title, String author, String dueDate, String bookStatus) {
        this.title = title;
        this.author = author;
        this.dueDate = dueDate;
        if(bookStatus.equals("CHECKEDOUT"))
            this.bookStatus= STATUS.CHECKEDOUT;
        else
        this.bookStatus = STATUS.ONSHELF;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public STATUS getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(STATUS bookStatus) {
        this.bookStatus = bookStatus;
    }
}
