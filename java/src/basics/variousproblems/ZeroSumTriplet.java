package basics.variousproblems;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a sorted array, determine whether it contains three numbers
 * whose sum equals to 0.
 */
public class ZeroSumTriplet {

    public boolean findTriplet(int[] array) {
        Map<Integer, Integer> arr = new HashMap<Integer, Integer>(); // key = array value; value = array index
        for (int i = 0; i < array.length; i++) {
            arr.put(array[i], i);
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (i == j)
                    continue;
                int candidateSum = array[i] + array[j];
                if (arr.containsKey(0 - candidateSum) &&
                        arr.get(0 - candidateSum) != i &&
                        arr.get(0 - candidateSum) != j) {
                    System.out.println(array[i] + " + " + array[j] + " + " + (0 - candidateSum) + " = 0");
                    return true;
                }
            }
        }
        System.out.println("No three numbers exist that sum to 0.");
        return false;
    }

    public static void main(String[] args) {
        ZeroSumTriplet zeroSum = new ZeroSumTriplet();
        int[] array = new int[]{1, 2, 4, 7, 11, -15};
        zeroSum.findTriplet(array);
        array = new int[]{1, 2, 4, 7, 11, 15};
        zeroSum.findTriplet(array);
    }

}
