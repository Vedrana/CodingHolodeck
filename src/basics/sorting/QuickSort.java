package basics.sorting;

import java.util.Random;

public class QuickSort {

	private static int partition(int[] array, int left, int right, int pivot) {
		int pivotValue = array[pivot];
		array[pivot] = array[right]; // swap pivot element and rightmost element
		array[right] = pivotValue;
		int storeIndex = left;
		for (int i = left; i < right; i++) {
			if (array[i] < pivotValue) {
				int storeIndexElem = array[storeIndex];
				array[storeIndex] = array[i];
				array[i] = storeIndexElem;
				storeIndex++;
			}
		}
		int storeIndexElem = array[storeIndex];
		array[storeIndex] = array[right]; // thats pivot value
		array[right] = storeIndexElem;
		return storeIndex;
	}
	
	public static void quicksort(int[] array, int left, int right) {
		if (left < right) { // the list has more than 2 elements
			Random ran = new Random();
			int pivotIndex = left + ran.nextInt(right-left+1);
			int newPivotIndex = partition(array, left, right, pivotIndex);			
			// recursively sort elements smaller and greater than pivot element
			quicksort(array, left, newPivotIndex - 1);
			quicksort(array, newPivotIndex + 1, right);
		}
	}

	public static void main(String[] args) {
		int array[] = new int[] {5, 3, 7, 8, 2, 9, 1, 4, 7};
		quicksort(array, 0, array.length - 1);
		for (int i : array) {
			System.out.print(i + " ");
		} 
	}

}
