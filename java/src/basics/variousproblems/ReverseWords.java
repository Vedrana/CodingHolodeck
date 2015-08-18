package basics.variousproblems;


/**
 * Given a linked list containing characters that form a string such as
 * "my career stack". Reverse the characters of each word, keeping the order of
 * the words same such that the output will be "ym reerac kcats"
 * <br/><br/>
 * http://www.mycareerstack.com/question/317/reverse-characters-of-each-word-in-a-sentence/
 * 
 * @author vedrana
 * 
 */
public class ReverseWords {

	public static String reverseWords(String sentence) {
		char[] sent = sentence.toCharArray();
		int start = 0;
		int length = sent.length;
		for (int i = 0; i < length; i++) {
			if (sent[i] == ' ' || i == length - 1) {
				reverseWord(sent, start, i == length - 1 ? i : i - 1);
				start = i + 1;
			}
		}
		return new String(sent);
	}

	public static String reverseWords2(String sentence) {
		String[] sent = sentence.split(" ");
		for (int i = 0; i < sent.length; i++) {
			sent[i] = reverseWord(sent[i].toCharArray(), 0,
					sent[i].length() - 1);
		}

		StringBuilder sb = new StringBuilder();
		sb.append(sent[0]);
		for (int i = 1; i < sent.length; i++) {
			sb.append(" " + sent[i]);
		}
		return sb.toString();
	}

	/**
	 * 
	 * @param sent
	 *            list of characters in which we reverse the part from start to
	 *            finish
	 * @param start
	 *            starting index from which we're reversing
	 * @param finish
	 *            end last index, included, to which we're reversing
	 */
	private static String reverseWord(char[] sent, int start, int finish) {
		for (int i = 0; i < (finish - start + 1) / 2; i++) {
			char tmp = sent[start + i];
			sent[start + i] = sent[finish - i];
			sent[finish - i] = tmp;
		}
		return new String(sent); // because reverseWords is used in both
									// methods. Lazy.
	}

	public static void main(String[] args) {
		String sentence = "This is a really large sentence";
		System.out.println(reverseWords(sentence));
		System.out.println(reverseWords2(sentence));

	}

}
