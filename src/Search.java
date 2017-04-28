import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by PAS8 on 4/25/2017.
 */
public class Search {

    //Method to search book by author
    static void searchBookByAuthor(ArrayList <Book> bookList, Scanner scan) {
        boolean found =false;
        System.out.println("Enter the author's name");
        String author = scan.nextLine();
        for (Book temp : bookList) {
            if (temp.getAuthor ().equals ( author )) {
                found = true;
                System.out.println ( temp );
            }
        }
        if(!found)
        System.out.println("Did not find the book");
    }

    //Method to search book by title
    static void searchBookByTitle(ArrayList <Book> bookList, Scanner scan) {
        System.out.println("Enter in the book's title");
        String title = scan.nextLine();
        boolean found = false;
        for (Book temp : bookList) {
            if (temp.getTitle ().equals ( title )) {
                System.out.println ( temp );
                found = true;
            }
        }
        if (!found)
            System.out.println("Did not  find the book");
    }
}
