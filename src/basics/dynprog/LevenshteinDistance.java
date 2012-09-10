package basics.dynprog;

// http://en.wikipedia.org/wiki/Levenshtein_distance
public class LevenshteinDistance {

	public static int computeLevenshteinDistance(final String s1, final String s2) {
		final char[] word1 = s1.toCharArray();
		final char[] word2 = s2.toCharArray();
		
		// dist[i,j] -- Levenshtein distance between the first i 
		// characters of word1 and the first j characters of word2
		// note: we consider the empty string too!
		final int[][] dist = new int[word1.length+1][word2.length+1];
		
		// source prefixes to empty string: dropping all characters
		for (int i = 1; i <= word1.length; i++) {
			dist[i][0] = i;
		}
		
		// target prefixes from empty source prefix: inserting all characters
		for (int i = 1; i <= word2.length; i++) {
			dist[0][i] = i;
		}
		
		for (int i = 1; i <= word1.length; i++) {
			for (int j = 1; j <= word2.length; j++) {
				if (word1[i-1] == word2[j-1]) {
					dist[i][j] = dist[i-1][j-1]; // dont need to change anything
				} else {
					final int deletion = dist[i-1][j] + 1;
					final int insertion = dist[i][j-1] + 1;
					final int substitution = dist[i-1][j-1] + 1;
					dist[i][j] = min(deletion, insertion, substitution);
				}
			}
		}
		
		return dist[word1.length][word2.length];
	}
	
	private static int min (final int n1, final int n2, final int n3) {
		if (n1 < n2)
			return n1 < n3 ? n1 : n3;
		else
			return n2 < n3 ? n2 : n3;
	}
	
	public static void main(String[] args) {
		final String kitten = "kitten";
		final String sitting = "sitting";
		System.out.println(computeLevenshteinDistance(kitten, sitting)); // should be 3
		
		final String saturday = "saturday";
		final String sunday = "sunday";
		System.out.println(computeLevenshteinDistance(saturday, sunday)); // should be 3
	}

}
