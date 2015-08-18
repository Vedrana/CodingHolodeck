package crackingthecodinginterview;

/**
 * Rotate a NxN matrix by 90 degrees clockwise, in place
 *
 * @author vedrana
 */
public class Ch01Ex06 {

    public static void rotate(int[][] matrix) {
        int n = matrix[0].length;

        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i];

                // top = left
                matrix[first][i] = matrix[last - offset][first];
                // left = bottom
                matrix[last - offset][first] = matrix[last][last - offset];
                // bottom = right
                matrix[last][last - offset] = matrix[i][last];
                // right = top
                matrix[i][last] = top;
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
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        print(matrix);
        System.out.println("-------------");
        rotate(matrix);
        print(matrix);
    }

}
