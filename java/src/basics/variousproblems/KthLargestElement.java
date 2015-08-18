package basics.variousproblems;

import java.util.Random;

// In an unsorted array of integers, find the kth element
// in the sorted order (not the kth distinct element)
//
// == selection algorithm (quick select)
public class KthLargestElement {

  public int selectKth(int[] array, int k) {
    int left = 0;
    int right = array.length - 1;

    while (true) {
      Random ran = new Random();
      int pivot = ran.nextInt(right - left + 1);
      int newPivot = partition(array, left, right, pivot);
      int newPivotDist = newPivot - left + 1;
      if (newPivotDist == k) {
        return array[newPivot];
      } else if (k > newPivotDist) {
        left = newPivot + 1;
        k = k - newPivotDist;
      } else {
        right = newPivot - 1;
      }
    }
  }

  private int partition(int[] array, int left, int right, int pivotIndex) {
    int pivotValue = array[pivotIndex];
    array[pivotIndex] = array[right];
    array[right] = pivotValue;

    int newPivot = left;
    for (int i = left; i < right; i++) {
      if (array[i] < pivotValue) {
        int arrPivot = array[newPivot];
        array[newPivot] = array[i];
        array[i] = arrPivot;
        newPivot++;
      }
    }
    array[right] = array[newPivot];
    array[newPivot] = pivotValue;
    return newPivot;
  }

  public static void main(String[] args) {
    KthLargestElement kle = new KthLargestElement();
    int[] array = new int[]{3, 1, 2, 1, 4};
    int thirdElement = kle.selectKth(array, 3);
    System.out.println(thirdElement); // should be 2

    array = new int[]{3, 1, 2, 1, 4};
    int fifthElement = kle.selectKth(array, 5);
    System.out.println(fifthElement); // should be 4
  }

}
