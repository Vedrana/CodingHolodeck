package crackingthecodinginterview;

/**
 * Remove the duplicate characters in a string without using additional buffer
 * (one or two additional variables are fine, an extra copy of the array isn't).
 *
 * @author vedrana
 */
public class Ch01Ex03 {

  public static String removeDuplicates(String s) {
    StringBuilder sb = new StringBuilder();
    // 256 for extended ASCII
    boolean[] charHit = new boolean[256];
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (!charHit[c]) {
        charHit[c] = true;
        sb.append(c);
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println("blabla --> " + removeDuplicates("blabla"));
    System.out.println("abcdefgaaa --> " + removeDuplicates("abcdefgaaa"));
    System.out.println("aaaaa --> " + removeDuplicates("aaaaa"));
    System.out.println(" --> " + removeDuplicates(""));

  }

}
