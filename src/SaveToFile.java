import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by PAS8 on 4/25/2017.
 */
public class SaveToFile {
    public static void main(String[] args) {

        ArrayList <Book> bookList = new ArrayList <Book> ();
//        bookList.add ( new Book ( "Title1", "Author1", "None" ) );
//        bookList.add ( new Book ( "Title2", "Author2", "None" ) );
//        bookList.add ( new Book ( "Title3", "Author3", "None" ) );
//        bookList.add ( new Book ( "Title4", "Author4", "None" ) );
//        bookList.add ( new Book ( "Title5", "Author5", "None" ) );
//        bookList.add ( new Book ( "Title6", "Author6", "None" ) );
//        bookList.add ( new Book ( "Title7", "Author7", "None" ) );
//        bookList.add ( new Book ( "Title8", "Author8", "None" ) );
//        bookList.add ( new Book ( "Title9", "Author9", "None" ) );
//        bookList.add ( new Book ( "Title10", "Author10", "None" ) );
//

        readFromFile("test.txt",bookList);

        System.out.println ("Before");
        System.out.println (bookList.get ( 2 ));

        bookList.get(2).setBookStatus ( Book.STATUS.CHECKEDOUT );
        bookList.get(2).setAuthor ( "Trina" );

        System.out.println ("After");
        System.out.println (bookList.get ( 2));

        writeToFile ( bookList );

        //Ensure file exist or create one
        //createFile ( "test.txt" );
    }

    //Create file method
    static void createFile(String fileString) {
        Path filePath = Paths.get ( fileString );
        System.out.println ( filePath );

        if (Files.notExists ( filePath )) {
            System.out.println ( Files.notExists ( filePath ) );
            try {
                Files.createFile ( filePath );
            } catch (IOException e) {
                //e.printStackTrace ();
                System.out.println ( "There was an error: " + e );
            }
        }
    }

    //Read from file
    public static void readFromFile(String fileString, ArrayList <Book> bookList) {

        //Reference filename and pate
        Path filePath = Paths.get ( fileString );
        File fileName = filePath.toFile ();

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader ( fileName );

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader ( fileReader );
            try {
                //Read line by line
                //ArrayList<Book> bookArrayList = new ArrayList <> (  );
                while ((line = bufferedReader.readLine ()) != null) {
                    String[] information = line.split("\\|");
                    //System.out.println (information[0]);
                    //System.out.println (information[1]);
                    //System.out.println (information[2]);
                    //System.out.println (information[3]);
                    bookList.add (new Book(information[0], information[1], information[2], information[3]));
                    //System.out.println ("bookList = " + bookList);
                }
                // Always close files.
                bufferedReader.close ();
            } catch (IOException e) {
                //e.printStackTrace ();
                System.out.println ( "There was an error: " + e );
            }
        } catch (FileNotFoundException e) {
            //e.printStackTrace ();
            System.out.println ( "There was an error: " + e );
        }
    }

    //Write to file
    static void writeToFile(ArrayList <Book> bookList) {
        //Reference filename and pate
        Path filePath = Paths.get ( "test.txt" );
        File fileName = filePath.toFile ();

        try {
            // Assume default encoding.
            PrintWriter fileWriter = new PrintWriter ( new FileOutputStream ( fileName, false ) );

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter = new BufferedWriter ( fileWriter );

            // Note that write() does not automatically
            // append a newline character.
            for (Book temp : bookList) {
                bufferedWriter.write ( temp.getTitle () + "|" );
                bufferedWriter.write ( temp.getAuthor () + "|" );
                bufferedWriter.write ( temp.getBookStatus () + "|" );
                bufferedWriter.write ( temp.getDueDate () );
                bufferedWriter.newLine ();
            };
            System.out.println ( "The bookList has been saved!" );

            // Always close files.
            bufferedWriter.close ();
        } catch (IOException e) {
            //e.printStackTrace ();
            System.out.println ( "There was an error: " + e );
        }
    }
}
