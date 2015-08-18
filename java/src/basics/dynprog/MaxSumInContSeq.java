package basics.dynprog;


/**
 * You are given an array of integers (both positive and negative). Find the continuous sequence
 * with the largest sum. Return only the sum. <br/><br/>
 * Example: <br/>
 * Input: {2, -8, 3, 2, 4, -10} <br/
 * Output: 9. (i.e., {3, 2, 4})
 */
public class MaxSumInContSeq {

    public static int findMaxSumSeq(int[] sequence) {
        int maxSum = 0;

        // largestSum[i] - largest sum for first i elements
        int[] largestSum = new int[sequence.length];
        largestSum[0] = sequence[0];

        for (int i = 1; i < sequence.length; i++) {
            if (sequence[i] > largestSum[i - 1]) {
                largestSum[i] = sequence[i];
            } else if (largestSum[i - 1] + sequence[i] < sequence[i]) {
                largestSum[i] = sequence[i];
            } else {
                largestSum[i] = largestSum[i - 1] + sequence[i];
            }
            if (largestSum[i] > maxSum) {
                maxSum = largestSum[i];
            }
        }

        return maxSum;
    }

    private static String toString(int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length - 1; i++) {
            sb.append(array[i] + ", ");
        }
        sb.append(array[array.length - 1] + "]");
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] sequence = new int[]{2, -8, 3, 2, 4, -10};
        System.out.println(toString(sequence) + " : " + findMaxSumSeq(sequence));
        // should be 9

        sequence = new int[]{1, -1, 3, -1, 2, -10};
        System.out.println(toString(sequence) + " : " + findMaxSumSeq(sequence));
        // should be 4
    }
}
