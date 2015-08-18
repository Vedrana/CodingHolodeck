package basics.dynprog;

import java.util.HashSet;
import java.util.Set;

/***
 * http://en.wikipedia.org/wiki/Longest_common_substring_problem
 *
 * @author vedrana
 */
public class LongestCommonSubstring {

  // O(m*n)
  public static Set<String> findLongestSubstrings(String s1, String s2) {
    int[][] L = new int[s1.length()][s2.length()];
    int longestSubstrLen = 0;
    Set<Integer> longestSubstrIndexes = new HashSet<Integer>();
    for (int i = 0; i < s1.length(); i++) {
      for (int j = 0; j < s2.length(); j++) {
        if (s1.charAt(i) == s2.charAt(j)) {
          if (i == 0 || j == 0) {
            L[i][j] = 1;
          } else {
            L[i][j] = L[i - 1][j - 1] + 1;
          }
          if (L[i][j] > longestSubstrLen) {
            longestSubstrLen = L[i][j];
            longestSubstrIndexes.clear();
          }
          if (L[i][j] == longestSubstrLen) {
            longestSubstrIndexes.add(i);
          }
        } else {
          L[i][j] = 0;
        }
      }
    }
    Set<String> longestSubstrings = new HashSet<String>();
    for (Integer i : longestSubstrIndexes) {
      longestSubstrings.add(s1.substring(i - longestSubstrLen + 1, i + 1));
    }
    return longestSubstrings;
  }


  public static void main(String[] args) {
    Set<String> longestSubstrings = findLongestSubstrings("abab", "baba");
    for (String s : longestSubstrings) {
      System.out.println(s);
    }
  }

}
