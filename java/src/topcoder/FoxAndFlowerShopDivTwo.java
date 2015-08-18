package topcoder;

// SRM 552 div 2
public class FoxAndFlowerShopDivTwo {

  public int theMaxFlowers(String[] flowers, int r, int c) {
    int flowerRows = flowers.length;
    int flowerCols = flowers[0].length();

    int topRect = countFlowers(flowers, 0, 0, r, flowerCols);
    int leftRect = countFlowers(flowers, 0, 0, flowerRows, c);
    int rightRect = countFlowers(flowers, 0, c + 1, flowerRows, flowerCols - c - 1);
    int bottomRect = countFlowers(flowers, r + 1, 0, flowerRows - r - 1, flowerCols);

    return maxRect(topRect, leftRect, rightRect, bottomRect);
  }

  private int countFlowers(String[] flowers, int startRow, int startCol, int numOfRows, int numOfCols) {
    int numOfFlowers = 0;

    for (int i = startRow; i < startRow + numOfRows; i++) {
      for (int j = startCol; j < startCol + numOfCols; j++) {
        if (flowers[i].charAt(j) == 'F')
          numOfFlowers++;
      }
    }
    return numOfFlowers;
  }

  private int maxRect(int top, int left, int right, int bottom) {
    int max = 0;

    if (top > max)
      max = top;
    if (left > max)
      max = left;
    if (right > max)
      max = right;
    if (bottom > max)
      max = bottom;

    return max;
  }

  public static void main(String[] args) {
    FoxAndFlowerShopDivTwo fox = new FoxAndFlowerShopDivTwo();
    String[] flowers1 = {"F.F",
        ".F.",
        ".F."};
    int r = 0;
    int c = 1;
    System.out.println(fox.theMaxFlowers(flowers1, r, c)); // should be 2

    String[] flowers2 = {"F..",
        "...",
        "..."};
    r = 0;
    c = 0;
    System.out.println(fox.theMaxFlowers(flowers2, r, c)); // should be 0

    String[] flowers3 = {".FFF..F...",
        "FFF...FF.F",
        "..F.F.F.FF",
        "FF..F.FFF.",
        "..FFFFF...",
        "F....FF...",
        ".FF.FF..FF",
        "..F.F.FFF.",
        ".FF..F.F.F",
        "F.FFF.FF.F"};
    r = 4;
    c = 3;
    System.out.println(fox.theMaxFlowers(flowers3, r, c)); // should be 32

  }

}
