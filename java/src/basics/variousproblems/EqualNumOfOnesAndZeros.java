package basics.variousproblems;

/**
 * You have an array of 0s and 1s and you want to output all the intervals
 * (i, j) where the number of 0s and numbers of 1s are equal.
 * <br/><br/>
 * http://www.mycareerstack.com/question/295/interval-where-number-of-0s-and-1s-are-equal/
 *
 * @author vedrana
 */
public class EqualNumOfOnesAndZeros {

    public static int numOfIntervals(int[] array) {
        int arr_len = array.length;
        int[] numOfZeros = new int[arr_len];
        int[] numOfOnes = new int[arr_len];
        numOfOnes(array, numOfZeros, numOfOnes);

        int goodIntervalNum = 0;
        for (int start = 0; start < arr_len; start++) {
            for (int end = start + 1; end < arr_len; end++) {
                int zeros = numOfZeros[end] - (start > 0 ? numOfZeros[start - 1] : 0);
                int ones = numOfOnes[end] - (start > 0 ? numOfOnes[start - 1] : 0);
                if (zeros == ones) {
                    goodIntervalNum++;
                    System.out.println("[" + start + ", " + end + "]");
                }
            }
        }
        return goodIntervalNum;
    }

    private static void numOfOnes(int[] array, int[] zeros, int[] ones) {
        assert zeros.length == array.length && ones.length == array.length;
        if (array[0] == 0) {
            zeros[0] = 1;
            ones[0] = 0;
        } else {
            zeros[0] = 0;
            ones[0] = 1;
        }
        for (int i = 1; i < array.length; i++) {
            if (array[i] == 0) {
                zeros[i] = zeros[i - 1] + 1;
                ones[i] = ones[i - 1];
            } else {
                zeros[i] = zeros[i - 1];
                ones[i] = ones[i - 1] + 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 0, 0, 1, 1, 1, 1, 0};
        System.out.println(numOfIntervals(array));
    }

}
