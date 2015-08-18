package basics.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearch {

  public static boolean doBinarySearch(List<Integer> elements, Integer element) {
    if (elements.size() == 0) {
      return false;
    } else if (elements.size() == 1) {
      return elements.get(0) == element;
    }
    int middleIndex = elements.size() / 2;
    int middleElement = elements.get(middleIndex);
    if (middleElement == element) {
      return true;
    }
    if (element > middleElement) {
      return doBinarySearch(elements.subList(middleIndex, elements.size()), element);
    } else {
      return doBinarySearch(elements.subList(0, middleIndex), element);
    }
  }

  public static boolean doBinarySearchIteratively(List<Integer> elements, Integer element) {
    if (elements.size() == 0) {
      return false;
    } else if (elements.size() == 1) {
      return elements.get(0) == element;
    }
    int leftIndex = 0;
    int rightIndex = elements.size() - 1;
    int middleIndex = (rightIndex - leftIndex) / 2;

    while (leftIndex <= rightIndex) {
      middleIndex = (rightIndex - leftIndex) / 2 + leftIndex;
      int middleElement = elements.get(middleIndex);
      if (element == middleElement) {
        return true;
      } else if (element < middleElement) {
        rightIndex = middleIndex - 1;
      } else {
        leftIndex = middleIndex + 1;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    List<Integer> elements = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 6, 7, 9, 12));

    boolean elementsContainOne = doBinarySearch(elements, 1);
    System.out.println(elementsContainOne);
    boolean elementsContainTwo = doBinarySearch(elements, 2);
    System.out.println(elementsContainTwo);
    boolean elementsContainSix = doBinarySearch(elements, 6);
    System.out.println(elementsContainSix);
    boolean elementsContainTwelve = doBinarySearch(elements, 12);
    System.out.println(elementsContainTwelve);
    boolean elementsContainTwenty = doBinarySearch(elements, 20);
    System.out.println(elementsContainTwenty);

    System.out.println("--------------");

    elementsContainOne = doBinarySearchIteratively(elements, 1);
    System.out.println(elementsContainOne);
    elementsContainTwo = doBinarySearchIteratively(elements, 2);
    System.out.println(elementsContainTwo);
    elementsContainSix = doBinarySearchIteratively(elements, 6);
    System.out.println(elementsContainSix);
    elementsContainTwelve = doBinarySearchIteratively(elements, 12);
    System.out.println(elementsContainTwelve);
    elementsContainTwenty = doBinarySearchIteratively(elements, 20);
    System.out.println(elementsContainTwenty);
  }

}
