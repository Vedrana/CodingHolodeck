package basics.variousproblems;

import java.util.Stack;

/**
 * Move n-1 disks from A to B
 * Move disk n from A to C
 * Move n-1 disks from B to C so they sit on n
 *
 * @author vedrana
 */
public class TowerOfHanoi {

  public static void hanoi(int n, Stack<Integer> from, Stack<Integer> with, Stack<Integer> to) {
    printStack(from);
    printStack(with);
    printStack(to);
    System.out.println();

    if (n > 0) {
      hanoi(n - 1, from, to, with);
      moveDisk(from, to);
      hanoi(n - 1, with, from, to);
    }
  }

  private static void moveDisk(Stack<Integer> from, Stack<Integer> to) {
    Integer disk = from.pop();
    to.push(disk);
  }

  private static void fillStack(int n, Stack<Integer> stack) {
    for (int disk = n; disk > 0; disk--) {
      stack.push(new Integer(disk));
    }
  }

  // HORRIBLE
  private static void printStack(Stack<Integer> stack) {
    Stack<Integer> helperStack = new Stack<Integer>();
    while (stack.size() > 0) {
      Integer disk = stack.pop();
      helperStack.push(disk);
      System.out.print(disk + " ");
    }
    System.out.print("|");
    while (helperStack.size() > 0) {
      stack.push(helperStack.pop());
    }
  }

  public static void main(String[] args) {
    int n = 3;
    Stack<Integer> A = new Stack<Integer>();
    Stack<Integer> B = new Stack<Integer>();
    Stack<Integer> C = new Stack<Integer>();
    fillStack(n, A);
    hanoi(n, A, B, C);
  }

}
