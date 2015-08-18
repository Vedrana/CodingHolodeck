package basics.sorting;

import java.util.Random;

/***
 * Find k-th smallest number in an unsorted list
 *
 * @author vedrana
 */
public class QuickSelect {

    private static int partition(int[] array, int left, int right, int pivot) {
        int pivotElement = array[pivot];
        array[pivot] = array[right];
        array[right] = array[pivot];
        int newPivotIndex = left;
        for (int i = left; i < right; i++) {
            if (array[i] < pivotElement) {
                int elem = array[i];
                array[i] = array[newPivotIndex];
                array[newPivotIndex] = elem;
                newPivotIndex++;
            }
        }
        array[right] = array[newPivotIndex];
        array[newPivotIndex] = pivotElement;
        return newPivotIndex;
    }

    public static int select(int[] array, int k) {
        if (array.length < k) {
            throw new IllegalArgumentException("Well there is no kth element in a list with fewer than k elements.");
        } else if (array.length == 1) {
            return array[0];
        }
        int left = 0;
        int right = array.length - 1;
        while (true) {
            Random ran = new Random();
            int pivotIndex = left + ran.nextInt(right - left + 1);
            int newPivotIndex = partition(array, left, right, pivotIndex);
            int pivotDist = newPivotIndex - left + 1;
            if (pivotDist == k) {
                return array[newPivotIndex];
            } else if (k < pivotDist) {
                right = newPivotIndex - 1;
            } else {
                k = k - pivotDist;
                left = newPivotIndex + 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{9, 3, 8, 2, 1, 7, 4};
        int fifthElem = select(array, 5);
        System.out.println(fifthElem); // should be 7
    }

}
