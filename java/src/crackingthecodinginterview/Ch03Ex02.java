package crackingthecodinginterview;

import java.util.Stack;

/**
 * Design a stack which, in addition to push and pop, also has a function min
 * which returns the minimum element. Push, pop and min should operate in O(1) time.
 *
 * @author vedrana
 */
public class Ch03Ex02<T extends Comparable<T>> {

    Stack<T> stack;
    Stack<T> min;

    public Ch03Ex02() {
        stack = new Stack<T>();
        min = new Stack<T>();
    }

    public void push(T item) {
        stack.push(item);
        if (min.empty()) {
            min.push(item);
        } else if (item.compareTo(min.peek()) <= 0) {
            min.push(item);
        }
    }

    public T pop() {
        T item = stack.pop();
        if (item.compareTo(min()) == 0) {
            min.pop();
        }
        return item;
    }

    public T min() {
        if (!min.isEmpty()) {
            return min.peek();
        } else {
            return null;
        }

    }

    public static void main(String[] args) {
        Ch03Ex02<Integer> stack = new Ch03Ex02<Integer>();
        stack.push(3);
        stack.push(2);
        stack.push(1);
        stack.push(4);
        stack.push(0);
        stack.push(6);
        stack.push(0);
        System.out.println(stack.min()); // 0

        stack.pop();
        stack.pop();
        System.out.println(stack.min()); // 0

        stack.pop();
        System.out.println(stack.min()); // 1
    }

}
