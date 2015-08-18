package basics.variousproblems;

import java.util.ArrayList;
import java.util.List;

public class StringInterleaving {


  public static List<String> interleave(String s1, String s2) {
    return interleave(s1, s2, "");
  }

  private static List<String> interleave(String s1, String s2, String interleaved) {
    List<String> result = new ArrayList<String>();
    if (s1.length() == 0) {
      result.add(interleaved + s2);
      return result;
    } else if (s2.length() == 0) {
      result.add(interleaved + s1);
      return result;
    } else if (s1.length() == 0 && s2.length() == 0) {
      result.add(interleaved);
      return result;
    } else {
      char c1 = s1.charAt(0);
      String s1New = s1.substring(1);
      result.addAll(interleave(s1New, s2, interleaved + c1));

      char c2 = s2.charAt(0);
      String s2New = s2.substring(1);
      result.addAll(interleave(s1, s2New, interleaved + c2));

      return result;
    }
  }

  public static void main(String[] args) {
    List<String> interleaves = interleave("ab", "cd");
    for (String s : interleaves) {
      System.out.println(s);
    }
  }
}
