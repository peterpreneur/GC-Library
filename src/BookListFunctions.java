/**
 * Created by seandunn92 on 4/25/17.
 */

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class BookListFunctions {


    //Initialise ArrayList
    // ArrayList <Book> bookList = new ArrayList <Book> ();

    //Void method containing 12 books that will be stored in ArrayList<Book> if original txt file is empty
    public static void defBookList(ArrayList <Book> bookList) {
        bookList.add ( new Book ( "The Java Handbook",
                "Patrick Naughton, Michael Morrison" ) );
        System.out.println("flamingo");
        bookList.add ( new Book ( "Concurrent Programming in Java: Design Principles and Patterns",
                "Doug Lea" ) );
        bookList.add ( new Book ( "The Java Virtual Machine Specification",
                "Tim Lindholm, Frank Yellin, Bill Joy, Kathy Walrath" ) );
        bookList.add ( new Book ( "Java in a Nutshell: A Desktop Quick Reference for Java Programmers",
                "David Flanagan" ) );
        bookList.add ( new Book ( "The Java AWT Reference",
                "John Zukowski" ) );
        bookList.add ( new Book ( "The Java Language Specification",
                "James Gosling , Bill Joy, Guy Steele" ) );
        bookList.add ( new Book ( "Thinking in Java",
                "Bruce Eckel" ) );
        bookList.add ( new Book ( "Who's Afraid of Java?",
                "Steve Heller" ) );
        bookList.add ( new Book ( "The Java Programming Language, 2nd Edition",
                "Ken Arnold, James Gosling" ) );
        bookList.add ( new Book ( "Core Java 1.2: Volume 1 Fundamentals",
                "Gary Cornell, Cay Horstmann" ) );
        bookList.add ( new Book ( "The Java Class Libraries: An Annotated Reference",
                "Patrick Chan, Rosanna Lee" ) );
        bookList.add ( new Book ( "Teach Yourself Java 1.1 Programming in 24 Hours",
                "Rogers Cadenhead" ) );
    }


    public static void displayBooks(ArrayList <Book> bookList) { //taking in arraylist from library driver as param

        for (int i=0; i<bookList.size(); i++) {
            Book b = bookList.get(i);
            System.out.println("Book " + (i+1) + ": " +b);
        }

    }

    //Method to search book by title
    static void searchBookByTitle(ArrayList <Book> bookList, Scanner scan) {
        System.out.println("Enter in the book's title");
        String title = scan.nextLine();
        searchByString(bookList, title, true, scan);
    }



    //Void method to search book by Author
    public static void searchBookByAuthor(ArrayList <Book> bookList, Scanner scan) {
        boolean found = false;
        System.out.println ( "Enter the author's name" );
        String author = scan.nextLine ();




        searchByString(bookList, author, false,scan);
    }





    private static void searchByString(ArrayList<Book> bookList, String keyword, boolean searchByTitle, Scanner scan) {
        boolean found =false;
        String desiredMatch="";
        char userChar='g';


        for (Book temp : bookList) {
            if (searchByTitle)
                desiredMatch = temp.getTitle ().toLowerCase();
            else
                desiredMatch = temp.getAuthor ().toLowerCase();
            if (desiredMatch.contains ( keyword.toLowerCase() )) {
                found = true;
                System.out.println ( temp );
                if (temp.getBookStatus()!= Book.STATUS.CHECKEDOUT) {
                    System.out.println("Would you like to check out this book (y/n)?");
                    userChar = scan.nextLine().charAt(0);
                    if (userChar == 'y' || userChar == 'Y') {
                        CheckOutBook(temp);
                    }
                }



            }
        }
        if (!found) System.out.println ( "Did not find the book" );
    }





    //Void method to select book
    public static Book SelectBook(ArrayList <Book> bookList, Scanner scan) {

        int bookSel;
        //the book returned to user;
        Book retBook = null;

        do {
            bookSel = scan.nextInt ();
        } while (bookSel < 1 || bookSel > bookList.size ());
        retBook = bookList.get ( bookSel - 1 );
        return retBook;
    }

    //Void method to check out book (update STATUS to CHECKEDOUT).
    public static void CheckOutBook(Book bookWanted) {
        if (bookWanted.getBookStatus () == Book.STATUS.CHECKEDOUT) {
            System.out.println ( "Sorry that book was already checked out" );
            return;
        } else {
            bookWanted.setBookStatus ( Book.STATUS.CHECKEDOUT );
            updateDueDate ( bookWanted );
            System.out.println ( "We have checked " + bookWanted.getTitle () + " to you! Due " + bookWanted.getDueDate () );
        }
    }
    public static void ReturnBook(Book bookWanted){
        bookWanted.setBookStatus(Book.STATUS.ONSHELF);
        System.out.println("Thank You for returning " + bookWanted.getTitle());


    }

    public static void RemoveBookFromInventory(ArrayList<Book> bookList, Scanner scan){
        System.out.println("Please enter the book number that needs to be deleted");
        int index = scan.nextInt()-1;
        bookList.remove(index);
        System.out.println("New Inventory List:");
        displayBooks(bookList);

    }

    public static void AddBookTotheArray(ArrayList<Book> bookList, Scanner scan){
        System.out.println("What is the title?");
        String title = scan.nextLine();
        System.out.println("What is the author");
        String author = scan.nextLine();

        bookList.add(new Book(title, author));

    }

    private static void updateDueDate(Book bookWanted) {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, 14);

        SimpleDateFormat sdf= new SimpleDateFormat("MM/dd/yyyy");
        String output = sdf.format(c.getTime());
       bookWanted.setDueDate(output);
    }


}



