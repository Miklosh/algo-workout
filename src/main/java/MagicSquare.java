
public class MagicSquare {

    public static void main(String[] args) {
        int n = 3;
        int [][] matrix = new int[n][n];
        printMatrix(process(matrix, new Position(n / 2, n - 1, null), 0, n));
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


        // [LAST CHECK end work if every previous check returns false
        if (n%2 == 0) return matrix;
        if (position.row == n/2 && position.column == 0) {
            acc++;
            matrix[position.row][position.column] = acc;
            return matrix;
        } else {
            if (position.row >= 0 && position.row < n && position.column < n) {
                if (matrix[position.row][position.column] == 0) {
                    acc++;
                    matrix[position.row][position.column] = acc;
                    return process(matrix, new Position(position.row - 1, position.column + 1, position), acc, n);
                } else {
                    return process(matrix, new Position(position.previous.row, position.previous.column -1, position), acc, n);
                }
            } else {
                if (position.previous.row == 0 && position.previous.column == n-1) {
                    return process(matrix, new Position(position.previous.row,position.previous.column - 1, position.previous), acc, n);
                } else   if (position.previous.row == 0) {
                    return process(matrix, new Position(n-1, position.previous.column + 1, position.previous), acc, n);
                } else if (position.previous.column == n-1) {
                    return process(matrix, new Position(position.previous.row - 1, 0,position.previous ), acc, n);
                }
            }
            return matrix;
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
                System.out.print("[" +anAMatrix + "] ");
            }
        }
    }

    private static class Position {
        int row;
        int column;
        Position previous;

        Position(int row, int column, Position previous) {
            this.row = row;
            this.column = column;
            this.previous = previous;
        }
    }

}

