/*
 *  Name : Abisa Osei-Amankwah 
 * Purpose:  cell class implementation 
 * Last Updated:  10/16/23
 * 
 * 
 */

 import java.awt.Color;
 import java.awt.Graphics;

public class Cell {

    private int row; 

    private int col;

    private int value;

    private boolean locked;

    /**
     * construtor to make a a cell given a row, col, and value 
     * @param row
     * @param col
     * @param value
     */

    public Cell() {
        locked = false;
        this.col = 0;
        this.row = 0;
        this.value = 0; 


    }

    public Cell(int row, int col, int value){
        locked = false;
        this.col = col;
        this.row = row;
        this.value = value; 
    }

    /**
     * returns the number of rows of the cell 
     * @return
     */
    public int getRow(){

        return row; 

    }

    /**
     * returns the number of cols of the cell
     * @return
     */

    public int getCol() {

        return col;

    }

    /**
     * return the Cell's value 
     * @return
     */

    public int getValue() {

        Cell newCell = new Cell(row, col, value);

        return value; 

    }

    /**
     * set the Cell's value
     * @param newVal
     */

    public void setValue(int newVal) {

        Cell newCell = new Cell(row, col, value);

        value = newVal;



    }

    /**
     * return value of the locked field
     * @return
     */
    public boolean isLocked() {

        return locked;

    }
    /**
     * set the Cell's locked field to the new value
     * @param locked
     */

    public void setLocked(boolean lock) {

        locked = lock; 



    }

    /**
     * generate and return a representating String
     */

    public String toString() {

        Cell newCell = new Cell(row, col, value);

        return "(" + newCell.getValue() + ")";

    }
    
    public void draw(Graphics g, int x, int y, int scale){
        char toDraw = (char) ((int) '0' + getValue());
        g.setColor(isLocked()? Color.BLUE : Color.RED);
        g.drawChars(new char[] {toDraw}, 0, 1, x, y);
    }


    
}
