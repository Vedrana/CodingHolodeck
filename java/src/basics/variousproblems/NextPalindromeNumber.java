package basics.variousproblems;

// Given a number, find the next smallest palindrome larger than the number.
// For example if the number is 125, next smallest palindrome is 131.
//
// http://www.ardendertat.com/2011/12/01/programming-interview-questions-19-find-next-palindrome-number/
public class NextPalindromeNumber {

  public Integer findNextPalindrome(Integer number) {
    String num = Integer.toString(number);
    int numOfDigits = num.length();

    Integer candidate;
    String leftHalf = getLeftHalf(num);
    String reverseHalf = reverse(leftHalf);

    // odd number of digits
    if (numOfDigits % 2 == 1) {
      String middleDigit = getMiddleDigit(num);
      candidate = new Integer(leftHalf + middleDigit + reverseHalf);
      if (candidate > number) {
        return candidate;
      } else if (!middleDigit.equals("9")) {
        // increase the middle digit
        int increase = (int) Math.pow(10, numOfDigits / 2);
        return candidate + increase;
      } else {
        return findNextPalindrome(next(number, numOfDigits));
      }
    } else {
      candidate = new Integer(leftHalf + reverseHalf);
      String middleDigit = reverseHalf.substring(0, 1);
      if (candidate > number) {
        return candidate;
      } else if (!middleDigit.equals("9")) {
        // increase both middle digits
        int increase = 11 * (int) Math.pow(10, numOfDigits / 2 - 1);
        return candidate + increase;
      } else {
        return findNextPalindrome(next(number, numOfDigits));
      }
    }
  }

  private String getLeftHalf(String num) {
    int numOfDigits = num.length();
    return num.substring(0, numOfDigits / 2);
  }

  private String reverse(String num) {
    StringBuilder sb = new StringBuilder();
    for (int i = num.length() - 1; i >= 0; i--) {
      sb.append(num.substring(i, i + 1));
    }
    return sb.toString();
  }

  private String getMiddleDigit(String num) {
    int numOfDigits = num.length();
    return num.substring(numOfDigits / 2, numOfDigits / 2 + 1);
  }

  private Integer next(Integer number, int numOfDigits) {
    int increment = (int) Math.pow(10, numOfDigits / 2);
    return ((number + increment) / increment) * increment;
  }


  public static void main(String[] args) {
    NextPalindromeNumber npn = new NextPalindromeNumber();
    System.out.println(npn.findNextPalindrome(1234)); // 1331
    System.out.println(npn.findNextPalindrome(12345)); // 12421
    System.out.println(npn.findNextPalindrome(125)); // 131
    System.out.println(npn.findNextPalindrome(11)); // 22
    System.out.println(npn.findNextPalindrome(1)); // 2
    System.out.println(npn.findNextPalindrome(12933)); // 13031
    System.out.println(npn.findNextPalindrome(19)); // 22
    System.out.println(npn.findNextPalindrome(999)); // 1001
    System.out.println(npn.findNextPalindrome(9999)); // 10001
  }
}
