package basics.variousproblems;

import java.util.Stack;

// Given an input string, reverse all the words. To clarify, 
// input: “Interviews are awesome!” output: “awesome! are Interviews”.
// Consider all consecutive non-whitespace characters as individual words.
// If there are multiple spaces between words reduce them to a single
// white space. Also remove all leading and trailing whitespaces.
//
// http://www.ardendertat.com/2011/10/31/programming-interview-questions-12-reverse-words-in-a-string/
public class ReverseWordsInString {

	public String reverseWords(String sentence) {
		Stack<String> words = new Stack<String>();
		int i = 0;
		while (i < sentence.length()) {
			if (sentence.charAt(i) != ' ') {
				int start = i++;
				while (i < sentence.length() && sentence.charAt(i) != ' ') {
					i++;
				}
				words.add(sentence.substring(start, i));
			}
			i++;
		}
		if (words.isEmpty())
			return "";
		
		StringBuilder reversed = new StringBuilder();
		reversed.append(words.pop());
		while (!words.isEmpty()) {
			reversed.append(" " + words.pop());
		}
		return reversed.toString();
	}
	
	public static void main(String[] args) {
		ReverseWordsInString rev = new ReverseWordsInString();
		
		String sentence = " Interviews are     awesome!";
		System.out.println(sentence + " : " + rev.reverseWords(sentence));
		
		sentence = "";
		System.out.println(sentence + " : " + rev.reverseWords(sentence));
		
		sentence = "oneWord";
		System.out.println(sentence + " : " + rev.reverseWords(sentence));
		
	}

}
