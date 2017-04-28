import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by trina2 on 4/25/17.
 */
public class Trina {

    public static void main(String[] args) {
        Book book1= new Book("Cinderella", "Disney", "None");
        System.out.println(book1.getTitle()  +", " + book1.getBookStatus() + ", " + book1.getDueDate());
        System.out.println(book1);
        Book book2 = new Book ("Snow White", "Edgar Alan Poe", "None");
        System.out.println(book2);
        System.out.println();

        ArrayList<Book> bookList = new ArrayList<Book>();
        bookList.add(new Book ("Snow White2", "Edgar", "None"));
        // System.out.println(bookList.get(0));

        bookList.add(new Book("Harry Potter", "JK Rowling", "Today"));
        System.out.println(bookList);
        System.out.println("Welcome to Grand Circus Library");
        System.out.println("Please select from the following options:");
        System.out.println("1 - Display the entire list of books.");
        System.out.println("2 - Search for a book by author.");
        System.out.println("3 - Search for a book by title keyword.");
        System.out.println("4 - Select a book to check out.");
        System.out.println("5 - Return a book.");

        displayBooks(bookList); //passing in bookList method

        Scanner scan = new Scanner(System.in);
        int selection = 4;

        if (selection == 4) {
            displayBooks(bookList);
            System.out.println("Please select a book to check out: ");
            int select = scan.nextInt();
            //System.out.println (bookList.get ( scan.nextInt() ));

            if(true)
            System.out.println (bookList.get ( 1).getBookStatus().compareTo(Book.STATUS.CHECKEDOUT));


            Calendar c = Calendar.getInstance();
            c.setTime(new Date());
            c.add(Calendar.DATE, 14);

            SimpleDateFormat sdf= new SimpleDateFormat("MM/dd/yyyy");
            String output = sdf.format(c.getTime());
            System.out.println("This is our value " + output);

            bookList.get(select).setDueDate (output);
            bookList.get(select).setBookStatus ( Book.STATUS.CHECKEDOUT );
            System.out.println("You have checked out: " + bookList.get ( select ));

        }
    }

//write method to print arrayList "Books". Method that doesn't return anything but prints out list

    public static void displayBooks(ArrayList <Book> bookList) { //taking in arraylist from library driver as param

        for (Book b : bookList) {
            System.out.println(b);
        }

    }

}