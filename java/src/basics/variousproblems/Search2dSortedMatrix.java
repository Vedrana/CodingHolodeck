package basics.variousproblems;

public class Search2dSortedMatrix {

    public static boolean findElement(int[][] matrix, int element) {
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            int cell = matrix[row][col];
            System.out.println(cell);
            if (element == cell) {
                return true;
            } else {
                if (element > cell)
                    row++;
                else
                    col--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 9},
                {2, 5, 10, 11},
                {6, 8, 12, 13},
                {8, 9, 14, 16}};
        int element = 8;
        System.out.println(findElement(matrix, element));

    }

}
