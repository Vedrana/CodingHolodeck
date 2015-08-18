package crackingthecodinginterview;

/**
 * Write and algorithm such that if an element in an MxN matrix is 0, its
 * entire row and column is set to zero
 *
 * @author vedrana
 */
public class Ch01Ex07 {

    public static void letThereBeZeros(int[][] matrix) {
        boolean[] zeroRows = new boolean[matrix.length];
        if (zeroRows.length == 0) {
            throw new IllegalArgumentException("Matrix must have some rows :(");
        }
        boolean[] zeroColumns = new boolean[matrix[0].length];

        // If an element is zero, it's whole row and column will later be set to zero.
        // So we simply keep track of which rows and columns will be zero...
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    zeroRows[i] = true;
                    zeroColumns[j] = true;
                }
            }
        }
        // ... and then for each element, if it's in either in the row or in the column
        // which has to be zero, we change it to zero. So many zeros in these comments.
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (zeroRows[i] == true || zeroColumns[j] == true) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 0, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}};
        print(matrix);
        System.out.println("-------------");
        letThereBeZeros(matrix);
        print(matrix);
    }
}
