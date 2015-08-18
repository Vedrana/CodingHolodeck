package basics.datastruct;

public class Stack {
    private Integer size;
    private Node top;

    public Stack() {
        this.size = 0;
        this.top = null;
    }

    public Integer pop() {
        if (size > 0) {
            Integer value = top.value;
            top = top.next;
            size--;
            return value;
        } else {
            return (Integer) null;
        }
    }

    public void push(Integer value) {
        Node node = new Node(value, top);
        top = node;
        size++;
    }

    public void print() {
        while (size > 0) {
            Integer value = pop();
            System.out.println(value + " ");
        }
    }

    private class Node {

        public int value;
        public Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.pop();
        stack.pop();
        stack.push(5);

        stack.print();
    }

}
