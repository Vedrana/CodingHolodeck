package basics.variousproblems;

// Given a number, find the next smallest palindrome larger than the number.
// For example if the number is 125, next smallest palindrome is 131.
//
// http://www.ardendertat.com/2011/12/01/programming-interview-questions-19-find-next-palindrome-number/
public class NextPalindromeNumber {

	public Integer findNextPalindrome(Integer number) {
		 String num = Integer.toString(number);
		 int numOfDigits = num.length();
		 
		
		return 0;
	}
	
	private String getLeftHalf(String num) {
		int numOfDigits = num.length();
		return num.substring(0, numOfDigits/2);
	}
	
	// to be used with caution, only num has odd number of digits (and there actually is a middle one) 
	private Integer getMiddleDigit(String num) {
		int numOfDigits = num.length();
		return new Integer(num.substring(numOfDigits/2, numOfDigits/2+1));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
