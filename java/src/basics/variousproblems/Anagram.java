package basics.variousproblems;

import java.util.HashMap;
import java.util.Map;

public class Anagram {

  /**
   * Ignore space, punctuation and capitalization
   */
  public boolean areTheyAnagrams(String w1, String w2) {
    String word1 = w1.toLowerCase().replaceAll("[^A-Za-z0-9]", "");
    String word2 = w2.toLowerCase().replaceAll("[^A-Za-z0-9]", "");

    if (word1.length() != word2.length())
      return false;

    Map<String, Integer> letterCounts = new HashMap<String, Integer>();

    for (int i = 0; i < word1.length(); i++) {
      String letter = word1.substring(i, i + 1);
      if (letterCounts.containsKey(letter))
        letterCounts.put(letter, letterCounts.get(letter) + 1);
      else
        letterCounts.put(letter, 1);
    }
    for (int i = 0; i < word2.length(); i++) {
      String letter = word2.substring(i, i + 1);
      if (!letterCounts.containsKey(letter))
        return false;
      else if (letterCounts.get(letter) == 0)
        return false;
      else
        letterCounts.put(letter, letterCounts.get(letter) - 1);
    }
    for (String letter : letterCounts.keySet()) {
      if (letterCounts.get(letter) != 0)
        return false;
    }
    return true;
  }


  public static void main(String[] args) {
    Anagram granama = new Anagram();
    System.out.println(granama.areTheyAnagrams("Eleven plus two", "Twelve  plus one!")); // should be true

  }

}
