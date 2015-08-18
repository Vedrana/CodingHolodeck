package basics.variousproblems;

// Given an array of integers (positive and negative) find the largest continuous sum.
//
// http://www.ardendertat.com/2011/09/24/programming-interview-questions-3-largest-continuous-sum/
public class LargestContinuousSum {

	public Integer findSum(int[] arr) {
		if (arr.length == 0) 
			return null;
		
		int largestSum = arr[0];
		int currentSum = arr[0];
		for (int i = 1; i < arr.length; i++) {
			currentSum = max(currentSum + arr[i], arr[i]); // if the current sum gets negative, we reset it
			largestSum = max(currentSum, largestSum);
		}
		return largestSum;
	}
	
	private int max(int first, int second) {
		return first > second ? first : second;
	}

}
