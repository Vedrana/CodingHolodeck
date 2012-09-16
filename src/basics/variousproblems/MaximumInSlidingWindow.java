package basics.variousproblems;

import java.util.ArrayList;
import java.util.List;

// Given an array of numbers and a sliding window size,
// get the maximal numbers in all sliding windows
public class MaximumInSlidingWindow {

	public List<Integer> getMaximums(int[] array, int k) {
		List<Integer> result = new ArrayList<Integer>();
		List<Integer> indicesQueue = new ArrayList<Integer>();
		
		for (int i = 0; i < k; i ++) {
			int num = array[i];
			while (!indicesQueue.isEmpty() && array[indicesQueue.get(indicesQueue.size() - 1)] <= num) {
				indicesQueue.remove(indicesQueue.size() - 1);
			}
			indicesQueue.add(i);
		}
		
		for (int i = k; i < array.length; i++) {
			result.add(array[indicesQueue.get(0)]);
			
			int num = array[i];
			while (!indicesQueue.isEmpty() && array[indicesQueue.get(indicesQueue.size() - 1)] <= num) {
				indicesQueue.remove(indicesQueue.size() - 1);
			}
			while (!indicesQueue.isEmpty() && 
					(indicesQueue.get(indicesQueue.size() - 1) - indicesQueue.get(0) >= k)) {
				indicesQueue.remove(0);
			}
			indicesQueue.add(i);
		} 
		result.add(array[indicesQueue.get(0)]);
		return result;
	}
	
	public static void main(String[] args) {
		MaximumInSlidingWindow maxSliding = new MaximumInSlidingWindow();
		int[] array = new int[] {1, 3, -1, -3, 5, 3, 6, 7};
		int k = 3;
		
		List<Integer> maximums = maxSliding.getMaximums(array, k); // should be 3 3 5 5 6 7 
		for (Integer max : maximums)
			System.out.print(max + " ");
	}

}
