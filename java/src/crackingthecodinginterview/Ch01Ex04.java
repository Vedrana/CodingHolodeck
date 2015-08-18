package crackingthecodinginterview;

import java.util.Arrays;

/**
 * Cracking the coding interview, exercise 1.4. <br/>
 * See if two strings are anagrams.
 * @author vedrana
 *
 */
public class Ch01Ex04 {

	/**
	 * Case sensitive. <br/>
	 * Sort strings, then see if they're equal.
	 * @param a first string
	 * @param b second string
	 * @return true if anagram, else false
	 */
	public static boolean anagram(String a, String b) {
		if (a.length() != b.length()) {
			return false;
		} else {
			return sort(a).equals(sort(b));
		}
	}
	
	/**
	 * Case sensitive. <br/>
	 * See if counts of unique characters match.  
	 * @param a first string
	 * @param b second string
	 * @return true if anagram, else false
	 */
	public static boolean anagram2(String a, String b) {
		if (a.length() != b.length()) {
			return false;
		} 		
		// 256 elements for all extended ASCII characters
		int[] aCharCounts = new int[256];
		int[] bCharCounts = new int[256];
		for (int i = 0; i < a.length(); i++) {
			aCharCounts[a.charAt(i)]++;
			bCharCounts[b.charAt(i)]++;	
		}
		for (int i = 0; i < aCharCounts.length; i++) {
			if (aCharCounts[i] != bCharCounts[i]) {
				return false;
			}
		}
		return true;
	}
	
	private static String sort (String s) {
		char[] sChar = s.toCharArray();
		Arrays.sort(sChar);		
		return new String(sChar);
	}
	
	public static void main(String[] args) {
		System.out.println(anagram("vedrana", "anardev"));		// true 
		System.out.println(anagram("vedrana", "anardeva"));		// false
		System.out.println(anagram2("vedrana", "anardev"));		// true
		System.out.println(anagram2("vedrana", "anardeva"));	// false
		System.out.println(anagram2("ČŠĐŽĆ", "anardeva"));		// false
		System.out.println(anagram2("Vedrana", "anardev"));		// false
	}
	
}
