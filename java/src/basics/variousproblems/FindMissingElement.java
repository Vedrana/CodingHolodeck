package basics.variousproblems;

import java.util.HashMap;
import java.util.Map;

// There is an array of non-negative integers. A second array
// is formed by shuffling the elements of the first array and
// deleting a random element. Given these two arrays, find which
// element is missing in the second array.
//
// http://www.ardendertat.com/2011/09/27/programming-interview-questions-4-find-missing-element/
public class FindMissingElement {

  public int findMissingTheCoolWay(int[] firstArr, int[] secondArr) {
    int missing = 0;
    for (int i = 0; i < firstArr.length; i++) {
      missing = missing ^ firstArr[i];
    }
    for (int i = 0; i < secondArr.length; i++) {
      missing = missing ^ secondArr[i];
    }
    return missing;
  }

  public Integer findMissing(int[] firstArr, int[] secondArr) {
    Map<Integer, Integer> second = new HashMap<Integer, Integer>();
    for (int i = 0; i < secondArr.length; i++) {
      Integer num = new Integer(secondArr[i]);
      if (second.containsKey(num)) {
        second.put(num, second.get(num) + 1);
      } else {
        second.put(num, 1);
      }
    }
    Integer missing = null;
    for (int i = 0; i < firstArr.length; i++) {
      Integer num = new Integer(firstArr[i]);
      if (!second.containsKey(num)) {
        missing = num;
        break;
      } else {
        if (second.get(num) == 1)
          second.remove(num);
        else
          second.put(num, second.get(num) - 1);
      }
    }
    return missing;
  }

  public static void main(String[] args) {
    FindMissingElement fme = new FindMissingElement();

    int[] first = new int[]{1, 2, 3, 4, 5, 6};
    int[] second = new int[]{2, 4, 6, 3, 5};
    System.out.println(fme.findMissingTheCoolWay(first, second)); // should be 1
    System.out.println(fme.findMissing(first, second)); // should also be 1
  }

}
