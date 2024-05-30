/*
 *  Name : Abisa Osei-Amankwah 
 * Purpose:  
 * Last Updated:  10/16/23
 * 
 * 
 */

import java.util.Random;
import java.util.LinkedList;
import java.util.ArrayList;

public class Sudoku {

    private Board board;

    private LandscapeDisplay ld;

    /**
     * constructor
     */
    public Sudoku(int initalCells) {

        Random rand = new Random();

        board = new Board();

        ld = new LandscapeDisplay(board);

        for (int i = 0; i < initalCells; i++) { // + 1
            int randRow = rand.nextInt(9);

            int randCol = rand.nextInt(9);

            int randValue = rand.nextInt(9) + 1;
            if (!board.isLocked(randRow, randCol) && board.validValue(randRow, randCol, randValue)) {

                board.set(randRow, randCol, randValue);
                board.set(randRow, randCol, true);

            }

        }

    }

    /**
     * 
     * @return
     */
    public int findNextValue(int row, int col) {

        int curVal = board.value(row, col);

        for (int i = curVal + 1; i <= 9; i++) {

            if (board.validValue(row, col, i)) {
                // System.out.println(i);
                return i;
            }
        }

        // System.out.println(0);
        return 0;

    }

    /**
     * 
     * @return
     */
    public Cell findNextCell() {

        for (int row = 0; row < board.getRows(); row++) {
            for (int col = 0; col < board.getCols(); col++) {
                if (board.value(row, col) == 0) {

                    int newVal = findNextValue(row, col);

                    if (newVal != 0) {
                        board.set(row, col, newVal);

                        return board.get(row, col);

                    }
                    // else {
                    // return null;
                    // }

                }

            }

        }

        return null;

    }

    /**
     * 
     * @return
     * @throws InterruptedException
     */

    public boolean solve(int delay, int initalCells) throws InterruptedException {

        LinkedLists<Cell> stack = new LinkedLists<>();

        int emptyCells = board.getRows() * board.getCols();

        // System.out.println(emptyCells);

        while (stack.size() < emptyCells - initalCells) {
            if (delay > 0) {
                Thread.sleep(delay);
            }
            if (ld != null) {
                ld.repaint();
            }

            Cell next = findNextCell();

            while (next == null && !stack.isEmpty()) {

                Cell poppedCell = stack.pop(); 
                //stack.peek();
                // System.out.println(poppedCell + "pop");

                int nextVal = findNextValue(poppedCell.getRow(), poppedCell.getCol());

                board.set(poppedCell.getRow(), poppedCell.getCol(), nextVal);

                if (poppedCell.getValue() != 0) {

                    // next = findNextCell();
                    next = poppedCell;
                }
               

            }

            if (next == null) {

                return false;

            } else {

                stack.push(next);
                // System.out.println(next + "next");
                // System.out.println(stack);
            }

            

        }

        return true;
    }

    public static void main(String[] args) throws InterruptedException {

        Sudoku sudoku1 = new Sudoku(40);

        // Sudoku sudoku2 = new Sudoku(20);

        sudoku1.solve(0, 40);

        // System.out.println(sudoku1.solve(10, 10));

    }

}
