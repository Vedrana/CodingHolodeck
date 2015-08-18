package topcoder;

// SRM 550 div 2
public class EasyConversionMachine {
    public String isItPossible(String originalWord, String finalWord, int k) {
        int diffChars = 0;
        for (int i = 0; i < originalWord.length(); i++) {
            if (originalWord.charAt(i) != finalWord.charAt(i))
                diffChars++;
        }
        if (diffChars > k)
            return "IMPOSSIBLE";
        else if (diffChars == k)
            return "POSSIBLE";
        else if ((k - diffChars) % 2 == 0)
            return "POSSIBLE";
        else
            return "IMPOSSIBLE";
    }
}