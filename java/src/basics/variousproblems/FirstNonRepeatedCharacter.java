package basics.variousproblems;

import java.util.HashMap;
import java.util.Map;

// Find the first non-repeated (unique) character in a given string.
//
// http://www.ardendertat.com/2011/11/14/programming-interview-questions-15-first-non-repeated-character-in-string/
public class FirstNonRepeatedCharacter {

	public String findFirstUnique(String s) {
		Map<String, Integer> letterCounts = new HashMap<String, Integer>();
		for (int i = 0; i < s.length(); i++) {
			String letter = s.substring(i, i+1);
			if (!letterCounts.containsKey(letter)) {
				letterCounts.put(letter, 1);
			} else {
				letterCounts.put(letter, letterCounts.get(letter) + 1);
			}
		}
		for (int i = 0; i < s.length(); i++) {
			String letter = s.substring(i, i+1);
			if (letterCounts.get(letter) == 1) {
				return letter;
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		FirstNonRepeatedCharacter uniq = new FirstNonRepeatedCharacter();
		System.out.println(uniq.findFirstUnique("blablablas")); // s
		System.out.println(uniq.findFirstUnique("whatsthis")); // w
		System.out.println(uniq.findFirstUnique("whatsthistherescolorseverywhere")); // a
		System.out.println(uniq.findFirstUnique("whatsthisthereswhitethingsintheair")); // g

	}

}
