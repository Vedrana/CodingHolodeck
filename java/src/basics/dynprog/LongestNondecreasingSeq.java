package basics.dynprog;


/**
 * Given a sequence of N numbers - A[1] , A[2] , ..., A[N].
 * Find the length of the longest non-decreasing sequence. <br/>
 * See <a href="http://community.topcoder.com/tc?module=Static&d1=tutorials&d2=dynProg">TopCoder tutorial</a>
 *
 * @author vjankovic
 */
public class LongestNondecreasingSeq {


  public static int findLongestNondecreasingSeqLength(int[] sequence) {

		/* A state i is the longest non-decreasing sequence which has its last number A[i].
         * This state carries only data about the length of this sequence.
		 */
    int[] nondecrSeq = new int[sequence.length];
    nondecrSeq[0] = 1;

    int longestNondecrSeqLen = 0;

    for (int i = 1; i < sequence.length; i++) {
      if (sequence[i] >= sequence[i - 1]) {
        nondecrSeq[i] = nondecrSeq[i - 1] + 1;
      } else {
        nondecrSeq[i] = 1;
      }
      if (nondecrSeq[i] > longestNondecrSeqLen) {
        longestNondecrSeqLen = nondecrSeq[i];
      }
    }

    return longestNondecrSeqLen;
  }

  public static void main(String[] args) {
    System.out.println(findLongestNondecreasingSeqLength(new int[]{5, 3, 4, 8, 6, 7}));

  }

}
