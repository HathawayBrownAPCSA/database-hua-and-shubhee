/**
 * Creates a list of borrowed books
 *
 * @author Hua and Shubhee
 * @version 20210927
 */

import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class BorrowedBooks
{
    ArrayList<Book> bookList;
    
    /**
     * Constructor initializes a list of Books.
     */
    public BorrowedBooks()
    {
        bookList = new ArrayList<Book>();
    }
    
    // Loads a list of Books from fileName
  public BorrowedBooks (String fileName)
  {
    bookList = new ArrayList<Book>();
    //String fileName = "catalog.csv";
    
    // Open the file for input
    File file = new File(fileName);
    Scanner sourceFile = null;
    try
    {
        sourceFile = new Scanner(file);
    }
    catch (FileNotFoundException ex)
    {
        System.out.println("*** Cannot open " + fileName + " ***");
        System.exit(1);        // quit the program
    } 
    String dummy = sourceFile.nextLine();

    // Fill the Collection from the input file
    while (sourceFile.hasNext())
    {
      String str = sourceFile.nextLine();
      Book nextBook = new Book(str);
      insert(nextBook);
    }

    sourceFile.close();

     
  }
  
  public void writeToFile (String fileName)
  {
    // Open the file for output
    File file = new File (fileName);
    PrintWriter outputFile = null;

    try
    {
      outputFile = new PrintWriter(file); 
    }
    catch (FileNotFoundException ex)
    {
      System.out.println("*** Cannot create " + fileName);
    }
    
    // print the header
    outputFile.println("title, author, genre, pages");
    for (Book b : bookList)
    {
      outputFile.println(b.toCSV());
    }
    
    outputFile.close();  // crucial to clse the file when you're done 
  }
    
    /**
     * Adds Books to the list
     * @param i Book that user inputs into the system
     */
    public void addBook (Book i)
    {
        bookList.add(i);
    }
    
  /** Writes the BookList with a new line between each Book */
  public String toString()
  {
    String result = "";
    for (Book b : bookList)
    {
      result += b + "\n";
    }
    return result;
  }
    
    /**
     * Prints the list of borrowed books, and a message about returning them
     */
    public void printBorrowedBooks()
    {
        System.out.println("Here is a list of books you have borrowed: ");
        for (Book book : bookList)
        {
            System.out.println(book);
        }
    }
    
    /**
     * Verifies that author is on the list
     * @param a The author of the book
     */
    public boolean isAuthor (String a)
    {
        for (Book book : bookList)
        {
            String author = book.getAuthor();
            if(a.equalsIgnoreCase(author))
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Gets the book written by the author
     * @param a The author of the book
     * @return The book written by the input author
     */
    public Book getBookOfAuthor(String a)
    {
        for(Book book : bookList)
        {
            if(book.getAuthor().equalsIgnoreCase(a)){
                return book;
            }
        }
        return null;
    }
    
    /**
     * Verifies that book is on the list
     * @param a The title of the book
     */
    public boolean isBook (String a)
    {
        for (Book book : bookList)
        {
            String title = book.getTitle();
            if(a.equalsIgnoreCase(title))
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Gets the book with input title
     * @param a The title of the book
     * @return The book with the input title
     */
    public Book getBookOfTitle (String a)
    {
        for(Book book : bookList)
        {
            if(book.getTitle().equalsIgnoreCase(a)){
                return book;
            }
        }
        return null;
    }
    
    /*
   * Inserts the new book into the list in the appropriate place
   * @param b The Book to insert in the list
   */

  public void insert (Book b)
  {
      if(bookList.size() == 0)
      {
          bookList.add(b);
        }
      else
      {
          int loc = bookList.size();
          while((loc > 0) && (bookList.get(loc - 1).compareTo(b) > 0))
          {
              loc--;
            }
          bookList.add(loc, b);
        }
    }
    
  /**
   * Returns a list of books that meet the criteria
   */
  public ArrayList<Book> filter(String target)
  {
      ArrayList<Book> results = new ArrayList<Book>();
      for (Book book: bookList)
      {
          if(book.getGenre().equalsIgnoreCase(target) || 
             book.getAuthor().indexOf(target) >= 0 || 
             book.getTitle().indexOf(target) >= 0)
          {
              results.add(book);
          }
        }
      return results;
    }
}
