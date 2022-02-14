
/**
 * Books
 *
 * @author Hua and Shubhee
 * @version 20220211
 */

public class Book implements Comparable<Book>
{
    // attributes of a book
    private String title;
    private int pages;
    private String genre;
    private String fname;
    private String lname;
    private Genre genreList = new Genre();
    private String author;

    /**
     * Constructor initializes values for title, author, page count, and genre
     * 
     * 
     * @param t Title of book
     * @ param a Author of book
     * @param num Page count of book (integer)
     * @param g Genre of book
     * 
     */
    public Book(String t, String a, String g, int num)
    {
        // initialise instance variables
        title = t;
        pages = num;
        /*if(genreList.isValidGenre(g))
        {
            genre = g;
        }*/
        genre = g;
        author = a;
    }
    
    /**
     * Constructor initializes values for title, author, page count, and genre
     * 
     * @param s Info about book
     * 
     */
    public Book(String s)
    {
        InputLine bookInfo = new InputLine(s);
    
        String temp = bookInfo.nextToken();
        title = temp;
    
        /*temp = bookInfo.nextToken();
        lname = temp;
        
        temp = bookInfo.nextToken();
        fname = temp;
        
        author = fname + " " + lname;*/
        
        temp = bookInfo.nextToken();
        author = temp;
        
        temp = bookInfo.nextToken();
        genre = temp;
        
        temp = bookInfo.nextToken();
        pages = new Integer(temp);
    }
    
    /**
     * Returns user input about the Book
     * 
     * @return the title, author, and genre as a string
     * 
     */
    public String toString()
    {
       return title + " by " + author + ", " + genre + ", " + pages + " pages";
    }
    
  private String withQuotes (String s)
  {
    if (s.indexOf(',') >= 0)
    {
      return "\"" + s + "\"";
    }
    else
    {
      return s;
    }
  }
  
    public String toCSV()
  {
    /*String result = "";
    result += author + ","+ title + ",";
    result += genre + "," + pages;*/
    return (title) + ", " + (author) + ", " + genre + ", " + pages;
  }
    
    /**
     * Returns title of Book
     * @return title
     */
    public String getTitle()
    {
        return title;
    }
    
    /**
     * Returns author of Book
     * @return author
     */
    public String getAuthor()
    {
        return author;
    }
    
    /**
     * Returns genre of Book
     * @return genre
     */
    public String getGenre()
    {
        return genre;
    }
    
    /**
     * Updates genre
     * @param newGenre The new genre of the Book
     */
    public void setGenre(String newGenre)
    {
        genre = newGenre;
    }
    
    public int compareTo(Book other)
    {
      return (this.author.compareTo(other.author));
    }
}
