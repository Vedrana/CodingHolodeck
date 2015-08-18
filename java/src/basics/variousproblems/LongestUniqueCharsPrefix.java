package basics.variousproblems;

/**
 * Given a (possibly very long) string, finds the longest
 * prefix consisted of unique characters
 */
public class LongestUniqueCharsPrefix {

	public int findLongestPrefix(String s) {
		int[] charIndices = new int[256];
		for (int i = 0; i < charIndices.length; i++) {
			charIndices[i] = -1;
		}
		
		int left = 0;
		int longestPrefix = 0;
		
		for (int i = 0; i < s.length(); i++) {
			char letter = s.charAt(i);
			if (charIndices[letter] != -1) { // we already saw this letter
				left = charIndices[letter] + 1;
			} 
			charIndices[letter] = i;
			int prefixLen = i - left + 1;
			if (prefixLen > longestPrefix)
				longestPrefix = prefixLen;
		}
		return longestPrefix;
	}
	
	public static void main(String[] args) {
		LongestUniqueCharsPrefix l = new LongestUniqueCharsPrefix();
		String s = "abcdbefg";
		System.out.println(l.findLongestPrefix(s)); // should be 6
		s = "abcdbbefg";
		System.out.println(l.findLongestPrefix(s)); // should be 4
		s = "abcdbeff";
		System.out.println(l.findLongestPrefix(s)); // should be 5
		s = "aaabcdbefff";
		System.out.println(l.findLongestPrefix(s)); // should be 5
	}

}
