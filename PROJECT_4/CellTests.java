

public class CellTests {

    public static void main(String[] args){

        Cell cell = new Cell(0, 2, 1);
        System.out.println(cell.getRow());
        System.out.println(cell.getValue());
        System.out.println(cell.isLocked());
        cell.setValue(10);
        System.out.println(cell.getValue());
        cell.setLocked(true);
        System.out.println(cell.isLocked());
        System.out.println(cell.toString());



    }
    
}
