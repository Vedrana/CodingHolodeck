package basics.variousproblems;

/* We are given 3 strings: str1, str2, and str3. Str3 is said to be a
 * shuffle of str1 and str2 if it can be formed by interleaving the
 * characters of str1 and str2 in a way that maintains the left to right
 * ordering of the characters from each string.
 * For example, given str1=”abc” and str2=”def”, str3=”dabecf” is a valid
 * shuffle since it preserves the character ordering of the two strings.
 * So, given these 3 strings write a function that detects whether str3
 * is a valid shuffle of str1 and str2.
 * 
 * http://www.ardendertat.com/2011/10/10/programming-interview-questions-6-combine-two-strings/
 * */
public class CombineTwoStrings {

	public boolean canShuffle(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length())
			return false;
		
		if (s1.length() == 0)
			return s2.equals(s3);
		if (s2.length() == 0)
			return s1.equals(s3);
		
		if (s1.charAt(0) != s3.charAt(0) && s2.charAt(0) != s3.charAt(0))
			return false;
		
		if (s1.charAt(0) == s3.charAt(0) && canShuffle(s1.substring(1), s2, s3.substring(1))) 
			return true;
		if (s2.charAt(0) == s3.charAt(0) && canShuffle(s1, s2.substring(1), s3.substring(1)))
			return true;
		
		return false;
	}
	
	// without substringing
	public boolean canShuffle2(String s1, String s2, String s3) {
		return canShuffle2(s1, 0, s2, 0, s3, 0);
	}
	
	private boolean canShuffle2(String s1, int i1, String s2, int i2, String s3, int i3) {
		int s1Len = s1.length() - i1;
		int s2Len = s2.length() - i2;
		int s3Len = s3.length() - i3;
		
		if (s1Len + s2Len != s3Len)
			return false;
		
		if (s1Len == 0)
			return equalStrings(s2, i2, s3, i3);
		if (s2Len == 0)
			return equalStrings(s1, i1, s3, i3);
		
		if (s1.charAt(i1) != s3.charAt(i3) && s2.charAt(i2) != s3.charAt(i3))
			return false;
		
		if (s1.charAt(i1) == s3.charAt(i3) && canShuffle2(s1, i1 + 1, s2, i2, s3, i3 + 1))
			return true;
		if (s2.charAt(i2) == s3.charAt(i3) && canShuffle2(s1, i1, s2, i2 + 1, s3, i3 + 1))
			return true;
		
		return false;
	}

	private boolean equalStrings(String s1, int i1, String s2, int i2) {
		int s1Len = s1.length() - i1;
		int s2Len = s2.length() - i2;
		
		if (s1Len != s2Len)
			return false;
		
		for (int i = 0; i < s1Len; i++) {
			if (s1.charAt(i1 + i) != s2.charAt(i2 + i))
				return false;
		}
			
		return true;
	}
	
	public static void main(String[] args) {
		CombineTwoStrings cts = new CombineTwoStrings();
		System.out.println(cts.canShuffle("dude", "dog", "dodudeg")); // true
		System.out.println(cts.canShuffle("dude", "dog", "dowudeg")); // false
		System.out.println(cts.canShuffle2("dude", "dog", "dodudeg")); // true
		System.out.println(cts.canShuffle2("dude", "dog", "dowudeg")); // false
		
	}

}
