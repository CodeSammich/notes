import java.util.*;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
 
public class WordSearch {
  
  //Instance Variables
  private Character[][] grid;
  private Random r = new Random();
  private ArrayList<String> listOfWords;
    
  //Constructor
  public WordSearch () {
    grid = new Character[10][10];
    listOfWords = new ArrayList();
    for (int i = 0; i < grid.length; i++) 
      for (int j = 0; j < grid[0].length; j++) 
        grid[i][j] = '-';
  }
  
  public WordSearch (int length, int width) {
    grid = new Character[length][width];
    listOfWords = new ArrayList();
    for (int i = 0; i < grid.length; i++)
      for (int j = 0; j < grid[0].length; j++)
        grid[i][j] = '-';
  }
    
  public String toString() {
    String s = "    WORD SEARCH GRID    \n";
    for (int i = 0; i < grid.length;i++) {
      for (int j = 0; j < grid[0].length;j++) 
	      s += grid[i][j] + "  ";
      s += "\n\n";  
    }
    //List of Words
    s += "Words in Grid: \n";
    for(int l = 0; l < listOfWords.size(); l++)
      s += listOfWords.get(l) + "\n";
    return s;
  }
    
  public boolean addWordH(int row, int col, String s) {
    s = s.toUpperCase();

    if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length) {
      //If word fits horizontally
      if(s.length() + col > grid[row].length)
        return false;
      else {
        //Test for overlap
        for(int i = 0; i < s.length(); i++) {
          if (!(grid[row][col+i] == '-' || grid[row][col+i] == s.charAt(i)))
            return false;
        }
        //Break down s into characters and add them horizontally
        for(int i = 0; i < s.length(); i++) {
          if (grid[row][col+i] == '-' || grid[row][col+i] == s.charAt(i))
            grid[row][col + i] = s.charAt(i);
        }
        listOfWords.add(s);
        return true;
      }
    } 
    else
      return false;
  }
    
  public boolean addWordV(int row, int col, String s) {
    s = s.toUpperCase();
    
    if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length) {
      //If it fits vertically 
      if(s.length() + row > grid[col].length)
        return false;
      else {
        //Test for overlap
        for(int i = 0; i < s.length(); i++) {
          if (!(grid[row+i][col] == '-' || grid[row+i][col] == s.charAt(i)))
            return false;
        }
        //Fill in word
        for(int i = 0; i < s.length(); i++) {
          if (grid[row+i][col] == '-' || grid[row+i][col] == s.charAt(i))
            grid[row + i][col] = s.charAt(i);
        }
        listOfWords.add(s);
        return true;
      }
    }
    else 
      return false;
  }
    
  public boolean addWordD(int row, int col, String s) {
    s = s.toUpperCase();
	
    //If Rows and Cols are in range
    if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length) {
	    if(s.length() + row > grid.length || s.length() + col > grid[0].length)
        return false;
	    else {
        //Test for overlap
        for(int i = 0; i < s.length(); i++) {
          // if( grid[0].length - col >= s.length() && grid.length - row >=s.length())
          if (!(grid[row+i][col+i] == '-' || grid[row+i][col+i] == s.charAt(i)))
            return false;
        }
        //Fill in word
        for(int i = 0; i < s.length(); i++) {
          if (grid[row+i][col+i] == '-' || grid[row+i][col+i] == s.charAt(i))
            grid[row+i][col+i] = (s.charAt(i));
        }
        listOfWords.add(s);
        return true;
	    }
    }
    else 
	    return false;
  }
	
	public void fillGrid() {
    for (int i = 0; i < grid.length; i++)
	    for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == '-') { 
          Random r = new Random();
          Character c = (char)(r.nextInt(26) + 'A');
          grid[i][j] = c;
        }
	    }
  }
    
  //Here is code to read in words from wordlist and return it as an ArrayList:
  public ArrayList<String> loadDictionary() {
    String s = "zzz";
    ArrayList<String> dictionary = new ArrayList<String>();
	
    try {
	    FileReader f = new FileReader("wordlist.txt");
	    BufferedReader b = new BufferedReader(f);
	    while( s != null ) {
        s = b.readLine();
        if ( s != null )
          dictionary.add(s);
	    }
    }
    catch (IOException e) {}
	
    return dictionary;
  }
  
  public void addWords (int m) {
    ArrayList<String> originalList = loadDictionary();
    int row;
    int col;
    boolean fit = false;

    for (int i = 0; i < m; i++) {
      if (originalList.size() == 0) 
        fit = true;
      while (!fit) { //Go until word fits
        //New Location   
        row = r.nextInt(grid.length);
        col = r.nextInt(grid[0].length);
        int index = r.nextInt(originalList.size());
        String s = originalList.get(index);
        int direction = r.nextInt(3); //Chooses a random direction to test                                                                            
        if (direction == 0)
          if (addWordH(row, col, s))
            fit = true;
      
        if (direction == 1)
          if (addWordD(row, col, s))
            fit = true;
      
        if (direction == 2)
          if (addWordV(row, col, s))
            fit = true;
		
        if(fit)
          originalList.remove(index);
      }
    }
  }
   
  public static void main(String[] args) {
    WordSearch ws = new WordSearch();
    //working horizontal words
    ws.addWordH(0, 0, "hello");
    ws.addWordH(2, 4, "batman");
    ws.addWordH(5, 1, "apple");

    //Horizontal index error checking
    ws.addWordH(-2, 4, "joker");
    ws.addWordH(10, 4, "unicorn");  
    ws.addWordH(3, -1, "cowboys");
    ws.addWordH(5, 8, "dogs");

    //horizontal collision checking
    ws.addWordH(5, 3, "plow");
    ws.addWordH(2, 0, "neato");
        
    //working vertical words
    ws.addWordV(1, 0, "nice");
    ws.addWordV(4, 9, "yankee");
    ws.addWordV(4, 4, "old");
        
    //Verical index error checking
    ws.addWordV(-2, 4, "joker");
    ws.addWordV(7, 4, "unicorn");   
    ws.addWordV(3, -1, "cowboys");
    ws.addWordV(5, 20, "dogs");
        
    //vertical collision checking
    ws.addWordV(0, 4, "ores");
    ws.addWordV(4, 9, "goober");
       
    //working diagonal words
    ws.addWordD(7, 0,  "cat");
    ws.addWordD(0, 0, "home");
    ws.addWordD(0, 3, "loam");
 
    //Diagonal index error checking
    ws.addWordD(-2, 0,  "cat");
    ws.addWordD(3, -1,  "whelm");
    ws.addWordD(7, 7,  "after");    

    //Diagonal collision checking
    ws.addWordD(0, 4, "ores");
    ws.addWordD(4, 4, "oats");

    ws.addWords(5);                                                                                                              
    
    System.out.println(ws.toString());    
    ws.fillGrid();
    System.out.println(ws.toString());
    
    //WordSearch xy = new WordSearch();                                                                                             
    //System.out.println(xy);
  } 
}
