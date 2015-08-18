package topcoder;

// SRM 551 div2
public class ColorfulBricks {
    public int countLayouts(String bricks) {
        int numOfColors = 0;
        int[] colors = new int[256];
        for (int i = 0; i < 256; i++) {
            colors[i] = 0;
        }

        for (int i = 0; i < bricks.length(); i++) {
            colors[bricks.charAt(i)]++;
        }

        for (int i = 0; i < 256; i++) {
            if (colors[i] > 0)
                numOfColors++;
        }

        if (numOfColors == 1)
            return 1;
        else if (numOfColors == 2)
            return 2;
        else
            return 0;
    }

}