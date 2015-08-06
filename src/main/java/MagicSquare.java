import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.List;

public class MagicSquare {

    public static void main(String[] args) {
        int n = 5;
        int [][] matrix = new int[n][n];
        process(matrix,new Position(n/2,n-1), 1, n);
    }

    private static int[][] process(int[][] matrix, Position position, int acc, int n) {

//        [][] matrix = new int[n];
        // IF last right border AND there is at least one empty cell above in the same column
        // THEN go to last left border AND 1 row up AND i.b.o.
            // IF there is an empty place in 1 s.u. and 1 s.r. cell
            // THEN  step there AND i.b.o.
            // IF there is no empty cells 1up 1r THEN move to lower border 1 column right from current AND i.b.o.
                // (STEP1)IF there is an empty cell 1up 1r THEN step and ibo (repeat)
                    // IF there is no empty cell 1up 1r BUT IF but its not the last column
                    // THEN check is there an empty place to the left from current position AND repeat from step (STEP1)
                        // IF your in the last right column AND there is a row above current position
                        // THEN go to last right column and iterate one row up ibo
                            // IF if there is no cells up and left
                            // THEN move to lower border and move one column right ibo repeat STEP1

        // [MAIN ACTION is to iterate 1up 1r]

        // [CHECK LIST:
        // 1. IF lrb AND urp THEN goto llb 1ru THEN MA
        // 2. IF tb AND rcp THEN goto br 1r AND MA
        // 3. IF

        // 5 checks

        // [LAST CHECK end work if every previous check returns false


        if (position.row == n/2 && position.column == 0) {
            return matrix;
        } else {
             return process(/*current matrix*/ null,/*next position*/ null, /*accumulator*/ acc, /*matrix size*/ n);
        }

    }

    private static void fillMatrixWithTestValues(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int b = i + 1;
                int c = j + 1;
                String a = b +""+ c;
                matrix[i][j] = Integer.parseInt(a);
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] aMatrix : matrix) {
            System.out.println("");
            for (int anAMatrix : aMatrix) {
                System.out.print(anAMatrix + " ");
            }
        }
    }

    private static class Position {

        int row;
        int column;

        Position(int row, int column) {
            this.row = row;
            this.column = column;
        }
        static Position position(int row, int column) {
            return new Position(row, column);
        }

    }

}

