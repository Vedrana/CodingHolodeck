package basics.dynprog;

/**
 * Given a list of N coins, their values (V1, V2, ... , VN), and the total sum S.
 * Find the minimum number of coins the sum of which is S (we can use as many coins
 * of one type as we want), or report that it's not possible to select coins in such
 * a way that they sum up to S.<br/>
 * See <a href="http://community.topcoder.com/tc?module=Static&d1=tutorials&d2=dynProg">TopCoder tutorial</a>
 *
 * @author vjankovic
 */
public class Coins {

  public static int findMinNumOfCoinsForSum(int[] coins, int Sum) {
    int[] minNumOfCoinsForSum = new int[Sum + 1];
    minNumOfCoinsForSum[0] = 0;
    for (int i = 1; i < minNumOfCoinsForSum.length; i++) {
      minNumOfCoinsForSum[i] = 1000; // Should be positive infinity :)
    }

    for (int s = 1; s <= Sum; s++) {
      for (int c = 0; c < coins.length; c++) {
        if (coins[c] <= s && minNumOfCoinsForSum[s - coins[c]] + 1 < minNumOfCoinsForSum[s]) {
          minNumOfCoinsForSum[s] = minNumOfCoinsForSum[s - coins[c]] + 1;
        }
      }
    }
    return minNumOfCoinsForSum[Sum];
  }

  public static void main(String[] args) {
    System.out.println("Coins: 1, 3, 5");
    System.out.println("Sum:\tNumber of coins used:");
    for (int sum = 0; sum <= 11; sum++) {
      int minNumOfCoinsForSum = findMinNumOfCoinsForSum(new int[]{1, 3, 5}, sum);
      System.out.println(sum + "\t" + minNumOfCoinsForSum);
    }
  }
}
