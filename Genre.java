/**
 * Genre List
 *
 * @author Hua and Shubhee
 * @version 20210924
 */


import java.util.ArrayList;

public class Genre
{
    // instance variables - replace the example below with your own
    ArrayList<String> gList;
    
    /**
     * The constructor initializes an array list containing genres.
     * 
     */
    public Genre()
    {
        // Genre List
        gList = new ArrayList<String>();
        
        //Genres
        gList.add("Horror");
        gList.add("Mystery");
        gList.add("Thriller");
        gList.add("Fantasy");
        gList.add("Sci-Fi");
        gList.add("Children's");
        gList.add("Fiction");
        gList.add("Romance");
        gList.add("Classics");
        gList.add("Mythology");
        gList.add("Historical Fiction");
        gList.add("Poetry");
        gList.add("Self-Help");
        gList.add("Nonfiction");
        gList.add("Realistic Fiction");
    }
    
    /**
     * Checks that the genre input by the user is on the list
     * 
     * @param s Genre input by user
     * @return boolean of whether s is on the list or not
    */
    public boolean isValidGenre (String s)
    {
       boolean isValid = gList.contains(s);
       return true;
    }
    
    /**
     * Prints the list of genres.
     */
    public void printGenres(){
        System.out.println(gList);
    }
}
