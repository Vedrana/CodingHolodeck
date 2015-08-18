package basics.variousproblems;

// Given a sorted array of unknown length and a number to search for,
// return the index of the number in the array. Accessing an element
// out of bounds throws exception. If the number occurs multiple times,
// return the index of any occurrence. If it isn�t present, return -1.
//
// http://www.ardendertat.com/2011/11/21/programming-interview-questions-17-search-unknown-length-array/
public class SearchUnknownLengthArray {

  public int getIndex(int[] array, int number) {
    // check array indexes using powers of two
    int index = 0;
    int exponent = 0;

    while (true) {
      try {
        if (array[index] == number)
          return index;
        else if (array[index] < number)
          index = (int) Math.pow(2, exponent++);
        else
          break;
      } catch (IndexOutOfBoundsException e) {
        break;
      }
    }

    // binary search for number
    // left = 2^(m-1) + 1
    // right = 2^(m) - 1
    int left = index / 2 + 1;
    int right = index - 1;

    while (left <= right) {
      try {
        int middle = (left + right) / 2;
        if (array[middle] == number)
          return middle;
        else if (number < array[middle])
          right = middle - 1;
        else
          left = middle + 1;
      } catch (IndexOutOfBoundsException e) {
        right--;
      }
    }

    return -1;
  }


  public static void main(String[] args) {
    SearchUnknownLengthArray search = new SearchUnknownLengthArray();
    System.out.println(search.getIndex(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, 8));
    System.out.println(search.getIndex(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, 10));
  }

}
