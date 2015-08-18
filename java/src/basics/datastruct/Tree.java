package basics.datastruct;

import java.util.ArrayList;
import java.util.List;

/**
 * Just a regular, n-ary, not sorted generic tree, to educate myself
 *
 * @param <T>
 * @author vedrana
 */
public class Tree<T extends Comparable<T>> {

    private Node<T> root;

    public Tree(T value) {
        root = new Node<T>(value);
    }

    public Node<T> getRoot() {
        return root;
    }

    public void addChild(T child, Node<T> parent) {
        if (parent.children == null) {
            parent.children = new ArrayList<Node<T>>();
        }
        Node<T> childNode = new Node<T>(child);
        parent.children.add(childNode);
    }

    public Node<T> findNodeDFS(T value) {
        return findNodeDFS(new Node<T>(value), root);
    }

    private Node<T> findNodeDFS(Node<T> node, Node<T> currentNode) {
        if (currentNode == null) {
            return null;
        } else if (currentNode.equals(node)) {
            return currentNode;
        } else {
            List<Node<T>> children = currentNode.children;
            if (children != null && children.size() > 0) {
                for (Node<T> child : children) {
                    Node<T> result = findNodeDFS(node, child);
                    if (result != null) {
                        return result;
                    }
                }
            }
        }
        return null;
    }

    public void printDFS() {
        printDFS(root);
    }

    private void printDFS(Node<T> node) {
        List<Node<T>> children = node.children;
        if (children != null && children.size() > 0) {
            for (Node<T> child : children) {
                printDFS(child);
            }
        }
        System.out.print(node.value + " ");
    }

    public void BFS() {
        List<Node<T>> queue = new ArrayList<Node<T>>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node<T> currentNode = queue.remove(0);
            System.out.print(currentNode.value + " ");
            List<Node<T>> kids = currentNode.children;
            if (kids != null) {
                for (Node<T> child : kids) {
                    queue.add(child);
                }
            }
        }
    }

    /**
     * Print tree in level order. The output contains space between
     * the numbers in the same level, and new line between different
     * levels
     */
    public void levelOrderPrint() {
        List<Node<T>> queue = new ArrayList<Node<T>>();
        queue.add(root);

        int numOfElemsCurrent = 1; // the root
        int numOfElemsNext = 0;
        while (!queue.isEmpty()) {
            Node<T> currentNode = queue.remove(0);
            numOfElemsCurrent--;
            List<Node<T>> kids = currentNode.children;
            if (kids != null) {
                for (Node<T> child : kids) {
                    queue.add(child);
                    numOfElemsNext++;
                }
            }
            if (numOfElemsCurrent == 0) {
                System.out.print(currentNode.value + "\n");
                numOfElemsCurrent = numOfElemsNext;
                numOfElemsNext = 0;
            } else {
                System.out.print(currentNode.value + " ");
            }
        }

    }

    class Node<S extends Comparable<S>> {
        public S value;
        public List<Node<S>> children;

        public Node(S value) {
            this.value = value;
        }

        public boolean equals(Node<S> element) {
            return value.equals(element.value);
        }
    }

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<Integer>(2000);
        tree.addChild(1, tree.getRoot());
        tree.addChild(2, tree.getRoot());
        tree.addChild(3, tree.getRoot());
        tree.addChild(4, tree.getRoot());
        tree.addChild(10, tree.findNodeDFS(2));
        tree.addChild(20, tree.findNodeDFS(2));
        tree.addChild(30, tree.findNodeDFS(2));
        tree.addChild(100, tree.findNodeDFS(4));
        tree.addChild(200, tree.findNodeDFS(4));
        tree.addChild(300, tree.findNodeDFS(4));

        System.out.println("DFS:");
        tree.printDFS();

        System.out.println("\nBFS:");
        tree.BFS();

        System.out.println("\n\nLevels:");
        tree.levelOrderPrint();

        Tree<Integer> newTree = new Tree<Integer>(5);
        newTree.addChild(3, newTree.findNodeDFS(5));
        newTree.addChild(2, newTree.findNodeDFS(3));
        newTree.addChild(1, newTree.findNodeDFS(2));
        newTree.addChild(7, newTree.findNodeDFS(5));
        newTree.addChild(6, newTree.findNodeDFS(7));
        newTree.addChild(8, newTree.findNodeDFS(7));
        newTree.addChild(9, newTree.findNodeDFS(8));
        newTree.addChild(10, newTree.findNodeDFS(9));
        System.out.println("\nMore tree levels:");
        newTree.levelOrderPrint();
    }
}
