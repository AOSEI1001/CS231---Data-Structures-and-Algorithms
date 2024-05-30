
/*
 *  Name : Abisa Osei-Amankwah 
 * Purpose:  
 * Last Updated:  10/16/23
 * 
 * 
 */


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.awt.Color;
import java.awt.Graphics;
import java.lang.Math; 

public class Board {
    
    private Cell[][] board;

    private boolean finished;

    
    public static final int SIZE = 9;
    

    /**
     * Constructor for board
     */
    public Board() {

      //figure out how to change it to where it is board.size instead
      board = new Cell[SIZE][SIZE];

      
      for(int r = 0; r < SIZE; r++){
        for(int c = 0; c < board[0].length; c++){ //can be r if they are different lengths

          board[r][c] = new Cell();
        }
      }

    }

    public Board(int fixedCells) {
      
      Random rand = new Random();

      int randRow = rand.nextInt(SIZE);

      int randCol = rand.nextInt(SIZE);

      int randValue = rand.nextInt(SIZE) + 1;

      for (int i = 0; i < fixedCells + 1; i++) {
        if(!board[randRow][randCol].isLocked() && validValue(randRow, randCol, randValue)) {

          board[randRow][randCol].setValue(randValue);
          board[randRow][randCol].setLocked(true);

        }
 
      }
    }

  
    /**
     * returns the number of columns
     * @return
     */
    public int getCols(){
      return board[0].length;

    }

    /**
     * returns the number of rows
     * @return
     */
    public int getRows(){
      return board.length;

    }

    /**
     * returns whether the Cell at r, c, is locked
     * @param r
     * @param c
     * @return
     */
    
    public boolean isLocked(int r, int c){

      if (board[r][c].isLocked()) {

        return true;

      }
      return false;

      // return board[r][c].isLocked();



    }

    /**
     * returns the number of locked Cells on the board
     * @return
     */
    public int numLocked(){

      int lockedCount = 0;

      for (int row = 0; row < getRows(); row++) {
        for (int col = 0; col < getCols(); col++) {
          if (board[row][col].isLocked()) {

            lockedCount++;

          }
        }

      }
      return lockedCount;

    }

    /**
     * returns the value at Cell r, c
     * @param r
     * @param c
     * @return
     */
    public int value(int r, int c){

      int cellVal = board[r][c].getValue();

      return cellVal;

    }

    /**
     * returns the Cell at the given row and col
     * @param row
     * @param col
     * @return
     */

    public Cell get (int row, int col) {

        return board[row][col];

    }

    /**
     * sets the Cell at the given row and col to the given value 
     * @param row
     * @param col
     * @param value
     */

    public void set(int row, int col, int value) {

        board[row][col].setValue(value);
       

        

    }

    /**
     * this sets whether the Cell at the given row and col is locked
     * @param row
     * @param col
     * @param locked
     */

    public void set(int row, int col, boolean locked) {
        board[row][col].setLocked(locked);

    }


      /**
     *  tests if the given value is a valid value at the given row and column of the board
     * @param row
     * @param col
     * @param value
     * @return
     */

    public boolean validValue(int row, int col, int value) {

      //check the row and col of the given cell to see if the value is allowed to be there or not 
      // if the value is already at the given row or col then it is not a vaild value 
     
      int subGridSize = (int) Math.sqrt(SIZE);
      int perfectSquareRow = (row / subGridSize) * subGridSize; ;
      int perfectSquareCol = (col / subGridSize) * subGridSize; ;

        if (value > 9 || value < 1) {

          return false;
        }

        if (value <= 9 && value >= 1) {

          //checking its row 
          for(int r = 0; r < SIZE; r++) {

            if(r != row && board[r][col].getValue() == value) {
              return false;
            }
            

          }

          //checking its col 
          for (int c = 0; c < SIZE; c++) {

            if(c != col && board[row][c].getValue() == value) {
              return false;
            }

          }

          for (int i = perfectSquareRow; i < perfectSquareRow + subGridSize; i++){
            for(int j = perfectSquareCol; j < perfectSquareCol + subGridSize; j++) {

              if(i != row && j!= col && board[i][j].getValue() == value) {
                return false;
              } 

          }  
        
      }

     

    }
     return true;

  }


    /**
     * returns true if the board is solved
     * @return
     */
    public boolean validSolution() {

  //You can do this by looping over all of the Cells on the board. If any of the Cell values are 0 or are not valid (see prior function)
  // then the board is not solved. If all of the Cells are between 1 and 9 and all the Cells are valid, the board is solved.

      for (int r = 0; r < getRows(); r++) {
        for (int c = 0; c < getCols(); c++){
          

          if(board[r][c].getValue() == 0 || validValue(r, c, board[r][c].getValue())) { //|| !(board[r][c].validValue())
              return false;
          }
        }
      }

      return true;
    }

    /**
     * 
     * @param g
     * @param scale
     */
    public void draw(Graphics g, int scale){
      for(int i = 0; i<getRows(); i++){
          for(int j = 0; j<getCols(); j++){
              get(i, j).draw(g, j*scale+5, i*scale+10, scale);
          }
      } if(finished){
          if(validSolution()){
              g.setColor(new Color(0, 127, 0));
              g.drawChars("Hurray!".toCharArray(), 0, "Hurray!".length(), scale*3+5, scale*10+10);
          } else {
              g.setColor(new Color(127, 0, 0));
              g.drawChars("No solution!".toCharArray(), 0, "No Solution!".length(), scale*3+5, scale*10+10);
          }
      }
  }

    /**
     * 
     * @param filename
     * @return
     */

    public boolean read(String filename) {
    try {
      // assign to a variable of type FileReader a new FileReader object, passing filename to the constructor
      FileReader fr = new FileReader(filename);
      // assign to a variable of type BufferedReader a new BufferedReader, passing the FileReader variable to the constructor
      BufferedReader br = new BufferedReader(fr);
      
      // assign to a variable of type String line the result of calling the readLine method of your BufferedReader object.
      String line = br.readLine();
      // start a while loop that loops while line isn't null


      int row = 0;
      while(line != null){
          // print line
	  System.out.println( line );


          // assign to an array of Strings the result of splitting the line up by spaces (line.split("[ ]+"))
          String[] arr = line.split( "[ ]+" );
          // let's see what this array holds: 
          System.out.println("the first item in arr: " + arr[0] + ", the second item in arr: " + arr[1]);
          // print the size of the String array (you can use .length)
          System.out.println( arr.length );

          for(int col = 0; col < arr.length; col++) {
            board[row][col].setValue(Integer.parseInt(arr[col]));
          }
          // use the line to set various Cells of this Board accordingly
          // assign to line the result of calling the readLine method of your BufferedReader object.
          line = br.readLine();
      }
      // call the close method of the BufferedReader
      br.close();
      return true;
    }
    catch(FileNotFoundException ex) {
      System.out.println("Board.read():: unable to open file " + filename );
    }
    catch(IOException ex) {
      System.out.println("Board.read():: error reading file " + filename);
    }

    return false;
  }


  public String toString() {

    String StringBoard = " ";

    for (int r = 0; r < 9; r++) {
      for (int c = 0; c < 9; c++) {

        StringBoard += board[r][c] + " ";

      }
      StringBoard += "\n";

    }

  return StringBoard.toString();
    
  }


  //TESTING
  public static void main(String[]args) {

    Board initalBoard = new Board();

    // System.out.println(initalBoard.toString());

    String fileName = args[0];

    initalBoard.read(fileName);

    // initalBoard.toString();

    // initalBoard.set(0, 0, true);
    // initalBoard.set(1, 1, false);
    // initalBoard.set(4, 1, true);

    // for (int r = 0; r < initalBoard.getRows(); r++){
    //   for (int c = 0; c < initalBoard.getCols(); c++){

    //     if(initalBoard.isLocked(r, c)){

    //       System.out.println("This cell " + r + "," + c + " is locked(fixed)");

    //     }
        
    //   }
    // System.out.println(initalBoard.validSolution());
    
  }
}

