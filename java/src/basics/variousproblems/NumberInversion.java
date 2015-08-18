package basics.variousproblems;

// Given a positive integer in base 10, find its reverse,
// i.e. make the least significant digits the most significant
// and the opposite
public class NumberInversion {

  public int invert(int number) {
    int invert = 0;
    int num = number;

    while (num > 0) {
      invert = invert * 10 + num % 10;
      num /= 10;
    }
    return invert;
  }

  /**
   * Check if a number is a palindrome without
   * transforming it to string first
   */
  public boolean isPalindrome(int number) {
    return number == invert(number);
  }

  public static void main(String[] args) {
    NumberInversion numInv = new NumberInversion();
    System.out.println("123 is a palindrome: " + numInv.isPalindrome(123));
    System.out.println("12321 is a palindrome: " + numInv.isPalindrome(12321));
  }

}
