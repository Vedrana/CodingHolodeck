package basics.variousproblems;

/**
 * Given an increasingly sorted array and a number s,
 * find two numbers whose sum is s. If there are multiple
 * pairs with sum s, just output any one of them.
 */
public class NumbersWithAGivenSum {

	public boolean findNumbers(int[] array, int sum) {
		int left = 0;
		int right = array.length - 1;
		
		while (left < right) {
			int candidateSum = array[left] + array[right];
			if (candidateSum == sum) {
				System.out.println(array[left] + " + " + array[right] + " == " + sum);
				return true;
			} else if (candidateSum < sum) {
				left++;
			} else {
				right--;
			}
		}
		System.out.println("No two numbers exist that sum to " + sum + ".");
		return false;
	}
	
	public static void main(String[] args) {
		NumbersWithAGivenSum givenSum = new NumbersWithAGivenSum();
		int[] array = new int[] {1, 2, 4, 7, 11, 15};
		int wantedSum = 15;
		givenSum.findNumbers(array, wantedSum);
		int nonexistantSum = 20;
		givenSum.findNumbers(array, nonexistantSum);
	}

}
