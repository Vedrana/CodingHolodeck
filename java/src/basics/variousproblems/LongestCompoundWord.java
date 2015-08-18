package basics.variousproblems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// Given a sorted list of words, find the longest compound word
// in the list that is constructed by concatenating the words in the list.
//
// http://www.ardendertat.com/2012/06/15/programming-interview-questions-28-longest-compound-word/
public class LongestCompoundWord {

	Set<String> words;
	String[] wordsArr;
	
	public LongestCompoundWord(String[] words) {
		this.words = new HashSet<String>();
		this.words.addAll(Arrays.asList(words));
		this.wordsArr = words;
	}
	
	public String findLongestCompoundWord() {
		String longestCompoundWord = "";
		
		for (String word : wordsArr) {
			words.remove(word);
			if (isCompoundWord(word) && word.length() > longestCompoundWord.length())
				longestCompoundWord = word;
			words.add(word);
		}
		return longestCompoundWord;
	}
	
	public boolean isCompoundWord(String word) {
		if (words.contains(word))
			return true;
		for (int i = 0; i < word.length(); i++) {
			String pre = word.substring(0, i);
			String post = word.substring(i, word.length());
			if (words.contains(pre) && isCompoundWord(post)) {
				return true;
			}
		}
		return false;
	}

	
	public static void main(String[] args) {
		String[] words = new String[] {"cat", "cats", "catsdogcats", 
				"catxdogcatsrat", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcat", "ratcatdog", "ratcatdogcat"};
		LongestCompoundWord longestComp = new LongestCompoundWord(words);
		System.out.println("The longest compound word is " + longestComp.findLongestCompoundWord()); // should be ratcatdogcat

		longestComp.isCompoundWord("hippopotamuses");
	}

}
