package basics.variousproblems;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation {

  public List<String> permute(String s) {
    List<String> result = new ArrayList<String>();

    if (s.length() == 1) {
      result.add(s);
      return result;
    }

    String letter = s.substring(0, 1);
    List<String> permutations = permute(s.substring(1));
    for (String perm : permutations) {
      for (int i = 0; i < s.length(); i++) {
        result.add(perm.substring(0, i) + letter + perm.substring(i));
      }
    }

    return result;

  }

  public List<String> permuteIterative(String inputString) {
    List<String> currentPermutations = new ArrayList<String>();
    currentPermutations.add(inputString.substring(0, 1));

    List<String> levelUp = new ArrayList<String>();
    for (int i = 1; i < inputString.length(); i++) {
      String currentLetter = inputString.substring(i, i + 1);
      for (String permutation : currentPermutations) {
        for (int j = 0; j <= permutation.length(); j++) {
          levelUp.add(permutation.substring(0, j) + currentLetter + permutation.substring(j));
        }
      }
      currentPermutations.clear();
      currentPermutations.addAll(levelUp);
      levelUp.clear();
    }

    return currentPermutations;
  }

  public static void main(String[] args) {
    StringPermutation stringPermutation = new StringPermutation();
    List<String> permutations = stringPermutation.permute("abcde");
    for (String p : permutations) {
      System.out.println(p);
    }
    System.out.println(permutations.size()); // 5! = 120

    System.out.println("-------");

    List<String> permutationsIterative = stringPermutation
        .permuteIterative("abcde");
    for (String p : permutationsIterative) {
      System.out.println(p);
    }
    System.out.println(permutationsIterative.size()); // 5! = 120

  }

}
