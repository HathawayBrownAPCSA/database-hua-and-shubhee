/**
 * Tests the book class
 *
 * @author Hua and Shubhee
 * @version 20220211
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Library
{
    public static void main (String[] args)
    {
          Scanner kbd = new Scanner(System.in);
          Genre genreList = new Genre();
          int numBooks;
          BorrowedBooks bookList = new BorrowedBooks();
          //catalog
          System.out.println("Would you like to look through our catalog?");
          if(kbd.nextLine().equalsIgnoreCase("yes"))
          {
            BorrowedBooks books = new BorrowedBooks("booklist.csv");
            System.out.println(books);
            
            //filter books  
            System.out.println("Would you like to filter by something? Type yes or no");
              
              if(kbd.nextLine().equalsIgnoreCase("yes"))
              {
              System.out.println("What would you like to filter by?");
              String target = kbd.nextLine();
              System.out.println("\nFiltering by " + target + ":\n");
                
              ArrayList<Book> filtered = books.filter("h");
              for(Book b: filtered)
              {
                System.out.println(b);
                }
            }
            }
          
          //Number of books being borrowed
          System.out.println("Would you like to borrow some books?");
          if (kbd.nextLine().equalsIgnoreCase("yes"))
          {System.out.print("How many books would you like to borrow?: ");
          numBooks = kbd.nextInt();
          numBooks -= 1;
          
          String dummy = kbd.nextLine();
          
          for(int i = 0; i <= numBooks; i++)
          {
              //Information about the book
              System.out.print("Title: ");
              String title = kbd.nextLine();
              
              System.out.print("Author: ");
              String author = kbd.nextLine();
              
              System.out.print("Please put a genre in: ");
              genreList.printGenres();
              String genre = kbd.nextLine();
             
              System.out.print("Page count: ");
              int pages = kbd.nextInt();
              
              dummy = kbd.nextLine(); //clears the input line
              
              //Construct a new item
              Book nextBook = new Book(title, author, genre, pages);
              bookList.insert(nextBook);
            }
          
          //Prints a list of books being borrowed
          System.out.print("\n");
          bookList.printBorrowedBooks();
          
          //Get info about books
          System.out.println("Would you like to filter by something? Type yes or no");
          if(kbd.nextLine().equalsIgnoreCase("yes"))
          {
              System.out.println("What would you like to filter by?");
              String target = kbd.nextLine();
              System.out.println("\nFiltering by " + target + ":\n");
                
              ArrayList<Book> filtered = bookList.filter(target);
              for(Book b: filtered)
              {
                System.out.println(b);
                }
            }
          System.out.println("Have a nice day!");
        }
    }
    }

