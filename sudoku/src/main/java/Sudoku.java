import java.util.ArrayList;
import java.util.Objects;

public class Sudoku {
    //We have an array of arrays, where every sub-array is a row and every nth entry is a column.
    private ArrayList<ArrayList<Integer>> grid;

    public Sudoku() {
        //Default constructor: with no grid provided, we generate a null one to store it for future use.
        grid = new ArrayList<>();
        populateNullGrid();

       do {
            populateSudokuGrid();
        }
       while (!this.isSudokuGrid());
       System.out.println("Grid generated successfully!");
    }

    public Sudoku(ArrayList<ArrayList<Integer>> grid) {
        //Grid provided: assuming it is a sudoku grid, we store it for future use rather than generating one.
        this.grid = grid;
    }

    //Main grid generator that fills the grid with randomized numbers.
    public void populateSudokuGrid() {
        for (int i=0; i<9; ++i) {
            for (int j=0; j<9; ++j) {
                grid.get(i).set(j, (int)(Math.random() * 9) + 1);
            }
        }
        System.out.println();
    }

    //Basic grid generator that fills the grid with zeros.
    public void populateNullGrid() {
        for (int i=0; i<9; ++i) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j=0; j<9; ++j) {
                row.add(0);
            }
            grid.add(row);
        }
    }

    //Validation checker to see if a generated grid meets the requirements of being a sudoku grid. These checks are:
    /*
    * All the digits of a column must be different (since they are bound 1-9 by Math.random(), they will equal 45)
    * All the digits of a row must be different (same reasoning)
    * All the digits within 9 3x3 grids must be different (same reasoning)
    * These 3 checks have methods defined below.
    */
    public boolean isSudokuGrid() {
        return isSudokuColumn(this.grid) && isSudokuRow(this.grid) && isSudoku3x3(this.grid);
    }

    //Utility method to display the grid in the output terminal
    public void showGrid() {
        for (int i=0; i<9; ++i) {
            System.out.println(grid.get(i));
        }
    }

    public boolean isSudokuColumn(ArrayList<ArrayList<Integer>> grid) {
        for (int i=1; i<9; ++i) {
            for (int j=0; j<9; ++j) {
                //We linearly traverse each column and perform equality checks that would invalidate the property
                if (Objects.equals(grid.get(j).get(i), grid.get(j).get(i-1))) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isSudokuRow(ArrayList<ArrayList<Integer>> grid) {
        for (int i=0; i<9; ++i) {
            for (int j=1; j<9; ++j) {
                //We linearly traverse each row and perform equality checks that would invalidate the property
                if (Objects.equals(grid.get(i).get(j), grid.get(i).get(j - 1))) {
                    return false;
                }
            }
        }
        return true;
    }

    //TODO: IMPLEMENT 3X3 CHECK CHECK A SINGLE 3X3 SPACE 9X, ADJUSTING ROW, COL EACH CALL
    public boolean isSudoku3x3(ArrayList<ArrayList<Integer>> grid) {
        return true;
    }
}
