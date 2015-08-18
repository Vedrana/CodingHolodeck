package basics.variousproblems;

// Given an array and a value, implement a function to remove
// all instances of that value in place and return the new
// length. The order of elements can be changed. It doesn't
// matter what you leave beyond the new length.
public class RemoveNumbersInArray {

    public int remove(int[] array, int numToRemove) {
        int removedCounter = 0;
        int left = 0;
        int right = array.length - 1;
        while (array[right] == numToRemove && right >= 0)
            right--;
        while (left < right) {
            if (array[left] == numToRemove) {
                array[left] = array[right];
                array[right] = numToRemove;
                while (array[right] == numToRemove && right >= 0)
                    right--;
                removedCounter++;
            }
            left++;
        }
        return array.length - removedCounter;
    }

    public static void main(String[] args) {
        int[] array = new int[]{4, 3, 2, 1, 2, 3, 6};
        int numToRemove = 2;
        RemoveNumbersInArray numRem = new RemoveNumbersInArray();
        int newLength = numRem.remove(array, numToRemove);

        for (int i = 0; i < newLength; i++) {
            System.out.print(array[i] + " ");
        }
    }

}
