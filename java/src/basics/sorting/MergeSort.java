package basics.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {

  public static List<Integer> mergesort(List<Integer> list) {
    if (list.size() <= 1)
      return list;

    int middle = list.size() / 2;
    return merge(mergesort(list.subList(0, middle)), mergesort(list.subList(middle, list.size())));
  }

  public static List<Integer> merge(List<Integer> first, List<Integer> second) {
    List<Integer> merged = new ArrayList<Integer>();
    int i = 0;
    int j = 0;
    while (i < first.size() && j < second.size()) {
      if (first.get(i) < second.get(j)) {
        merged.add(first.get(i));
        i++;
      } else {
        merged.add(second.get(j));
        j++;
      }
    }
    merged.addAll(first.subList(i, first.size()));
    merged.addAll(second.subList(j, second.size()));

    return merged;
  }

  public static void main(String[] args) {
    List<Integer> list = new ArrayList<Integer>(Arrays.asList(9, 7, 5, 3, 1, 2, 4, 6, 8));
    List<Integer> sortedList = mergesort(list);
    System.out.println(sortedList);
  }

}
