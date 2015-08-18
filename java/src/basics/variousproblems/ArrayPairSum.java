package basics.variousproblems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// Given an integer array, output all pairs that sum up to a specific value k.
// http://www.ardendertat.com/2011/09/17/programming-interview-questions-1-array-pair-sum/
public class ArrayPairSum {

  // O(n*log(n))
  public void pairSum1(int[] arr, int k) {
    Arrays.sort(arr); // O(n*log(n))
    int l = 0;
    int r = arr.length - 1;

    while (l < r) { // O(n)
      int sum = arr[l] + arr[r];
      if (sum == k) {
        System.out.println(arr[l] + " + " + arr[r] + " = " + k);
        l++; // or r--;
      } else if (sum > k)
        r--;
      else
        l++;
    }

  }

  // O(n)
  public void pairSum2(int arr[], int k) {
    Set<Integer> seenNums = new HashSet<Integer>();
    for (int i = 0; i < arr.length; i++) {
      Integer elem = arr[i];
      if (seenNums.contains(k - elem))
        System.out.println(elem + " + " + (k - elem) + " = " + k);
      else
        seenNums.add(elem);
    }
  }

}
