package basics.datastruct;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> {

  private Node<T> root;

  public void add(T element) throws IllegalArgumentException {
    Node<T> elementNode = new Node<T>(element);
    if (root == null) {
      root = elementNode;
    } else {
      add(elementNode, root);
    }
  }

  private void add(Node<T> element, Node<T> parent) throws IllegalArgumentException {
    if (element.equals(parent)) {
      throw new IllegalArgumentException("Binary search tree must contain unique elements");
    }
    if (element.lessThan(parent)) {
      if (parent.left == null) {
        parent.left = element;
        return;
      } else {
        add(element, parent.left);
      }
    } else if (element.greaterThan(parent)) {
      if (parent.right == null) {
        parent.right = element;
        return;
      } else {
        add(element, parent.right);
      }
    }
  }

  public boolean contains(T element) {
    Node<T> elementNode = new Node<T>(element);
    return contains(elementNode, root);
  }

  private boolean contains(Node<T> element, Node<T> currentNode) {
    if (currentNode == null) {
      return false;
    } else if (element.equals(currentNode)) {
      return true;
    } else if (element.greaterThan(currentNode)) {
      return contains(element, currentNode.right);
    } else {
      return contains(element, currentNode.left);
    }
  }

  public int depth() {
    return depth(root);
  }

  private int depth(Node<T> node) {
    if (node == null) {
      return 0;
    } else {
      int leftDepth = depth(node.left);
      int rightDepth = depth(node.right);
      return 1 + (leftDepth > rightDepth ? leftDepth : rightDepth);
    }
  }

  public void traverseInorder() {
    traverseInorder(root);
  }

  private void traverseInorder(Node<T> node) {
    if (node == null)
      return;
    traverseInorder(node.left);
    System.out.print(node.value + " ");
    traverseInorder(node.right);
  }

  public void traversePreorder() {
    traversePreorder(root);
  }

  private void traversePreorder(Node<T> node) {
    if (node == null)
      return;
    System.out.print(node.value + " ");
    traversePreorder(node.left);
    traversePreorder(node.right);
  }

  public void traversePostorder() {
    traversePostorder(root);
  }

  private void traversePostorder(Node<T> node) {
    if (node == null)
      return;
    traversePostorder(node.left);
    traversePostorder(node.right);
    System.out.print(node.value + " ");
  }

  public void printLevels() {
    List<Node<T>> queue = new ArrayList<Node<T>>();
    queue.add(root);
    int currentLevel = 1;
    int nextLevel = 0;

    while (!queue.isEmpty()) {
      Node<T> currentNode = queue.remove(0);
      currentLevel--;
      System.out.print(currentNode.value + (currentLevel == 0 ? "\n" : " "));
      if (currentNode.left != null) {
        queue.add(currentNode.left);
        nextLevel++;
      }
      if (currentNode.right != null) {
        queue.add(currentNode.right);
        nextLevel++;
      }
      if (currentLevel == 0) {
        currentLevel = nextLevel;
        nextLevel = 0;
      }
    }
  }

  public void trim(T min, T max) {
    root = trim(root, min, max);
  }

  /**
   * Trim the tree such that all the numbers in the new tree are between min and max, inclusive
   */
  private Node<T> trim(Node<T> node, T min, T max) {
    if (node == null)
      return null;
    node.left = trim(node.left, min, max);
    node.right = trim(node.right, min, max);
    if (node.value.compareTo(min) >= 0 && node.value.compareTo(max) <= 0)
      return node;
    else if (node.value.compareTo(min) < 0)
      return node.right;
    else if (node.value.compareTo(max) > 0)
      return node.left;
    else
      return null;
  }

  private class Node<S extends Comparable<S>> {
    private S value;
    private Node<S> left;
    private Node<S> right;

    public Node(S value) {
      this.value = value;
    }

    public boolean greaterThan(Node<S> element) {
      return value.compareTo(element.value) > 0;
    }

    public boolean lessThan(Node<S> element) {
      return value.compareTo(element.value) < 0;
    }

    public boolean equals(Node<S> element) {
      return value.equals(element.value);
    }
  }

  public static void main(String[] args) {
    BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
    try {
      bst.add(5);
      bst.add(3);
      bst.add(7);
      bst.add(2);
      bst.add(1);
      bst.add(6);
      bst.add(8);
      bst.add(9);
      bst.add(10);
    } catch (IllegalArgumentException e) {
    }

    System.out.println("Depth: " + bst.depth());
    System.out.println("There " + (bst.contains(8) ? "is" : "isn't") + " an 8 in the tree");
    System.out.println("There " + (bst.contains(23) ? "is" : "isn't") + " a 23 in the tree");

    System.out.println("\nInorder traversal:");
    bst.traverseInorder();
    System.out.println("\nPreorder traversal:");
    bst.traversePreorder();
    System.out.println("\nPostorder traversal:");
    bst.traversePostorder();

    System.out.println("\nLevels traversal:");
    bst.printLevels();

    bst = new BinarySearchTree<Integer>();
    try {
      bst.add(8);
      bst.add(3);
      bst.add(10);
      bst.add(1);
      bst.add(6);
      bst.add(4);
      bst.add(7);
      bst.add(14);
      bst.add(13);
    } catch (IllegalArgumentException e) { }
    System.out.println("\nNew tree, levels traversal:");
    bst.printLevels();
    bst.trim(5, 13);
    System.out.println("\nTrimmed tree, levels traversal:");
    bst.printLevels();
  }
}

