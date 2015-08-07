
public class MagicSquare {

    public static void main(String[] args) {
        int n = 3;
        int [][] matrix = new int[n][n];
        printMatrix(process(matrix, new Position(n / 2, n - 1, null), 0, n));
    }

    private static int[][] process(int[][] matrix, Position position, int acc, int n) {
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

