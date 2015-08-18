package basics.variousproblems;

// Given a matrix of integers and coordinates of a rectangular region within the matrix,
// find the sum of numbers falling inside the rectangle. Our program will be called
// multiple times with different rectangular regions from the same matrix.

// http://www.ardendertat.com/2011/09/20/programming-interview-questions-2-matrix-region-sum/

/**
 * @author vedrana
 */
public class MatrixRegionSum {

  private int[][] matrix;
  private int[][] sums;

  public MatrixRegionSum(int[][] matrix) {
    this.matrix = matrix;
    precomputeSums();
  }

  // m*n each time, trivial
  public int getSum1(int topLeftX, int topLeftY, int bottomRightX, int bottomRightY) {
    int sum = 0;
    for (int i = topLeftY; i <= bottomRightY; i++) {
      for (int j = topLeftX; j <= bottomRightX; j++) {
        sum += matrix[i][j];
      }
    }
    return sum;
  }

  // m*n, only once
  private void precomputeSums() {
    int topRow = 0;
    int bottomRow = matrix.length - 1;
    int leftCol = 0;
    int rightCol = matrix[0].length - 1;

    sums = new int[bottomRow - topRow + 1][rightCol - leftCol + 1]; // all values initialized to 0 by default

    sums[topRow][leftCol] = matrix[topRow][leftCol];

    for (int col = leftCol + 1; col <= rightCol; col++) {
      sums[topRow][col] = sums[topRow][col - 1] + matrix[topRow][col];
    }
    for (int row = topRow + 1; row <= bottomRow; row++) {
      sums[row][leftCol] = sums[row - 1][leftCol] + matrix[row][leftCol];
    }

    for (int col = leftCol + 1; col <= rightCol; col++) {
      int colSum = matrix[topRow][col];
      for (int row = topRow + 1; row <= bottomRow; row++) {
        sums[row][col] = sums[row][col - 1] + matrix[row][col] + colSum;
        colSum += matrix[row][col];
      }
    }
  }

  // 1
  public int getSum2(int topLeftX, int topLeftY, int bottomRightX, int bottomRightY) {

    int OA = (topLeftX == 0 || topLeftY == 0) ? 0 : sums[topLeftY - 1][topLeftX - 1];
    int OB = (topLeftY == 0) ? 0 : sums[topLeftY - 1][bottomRightX];
    int OC = (topLeftX == 0) ? 0 : sums[bottomRightY][topLeftX - 1];
    int OD = sums[bottomRightY][bottomRightX];

    return OD - OB - OC + OA;
  }


  public static void main(String[] args) {
    MatrixRegionSum mrs = new MatrixRegionSum(new int[][]{{1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12},
        {13, 14, 15, 16}});
    System.out.println(mrs.getSum1(1, 1, 3, 2)); // should be 54
    System.out.println(mrs.getSum2(1, 1, 3, 2)); // should also be 54 :D

  }

}
