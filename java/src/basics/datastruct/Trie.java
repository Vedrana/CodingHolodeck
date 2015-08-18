package basics.datastruct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie {

  public Node root;

  public Trie() {
    root = new Node();
  }

  public boolean contains(String word) {
    Node currentNode = root;
    char[] letters = word.toCharArray();
    for (Character letter : letters) {
      if (!currentNode.children.containsKey(letter))
        return false;
      else
        currentNode = currentNode.children.get(letter);
    }
    return currentNode.isTerminal;
  }

  public String getItem(String word) {
    Node currentNode = root;
    char[] letters = word.toCharArray();
    for (Character letter : letters) {
      if (!currentNode.children.containsKey(letter))
        return null;
      else
        currentNode = currentNode.children.get(letter);
    }
    if (currentNode.isTerminal)
      return currentNode.someValue;
    else
      return null;
  }

  public void putItem(String word, String value) {
    Node currentNode = root;
    char[] letters = word.toCharArray();

    for (Character letter : letters) {
      if (!currentNode.children.containsKey(letter)) {
        Node newNode = new Node(letter);
        currentNode.children.put(letter, newNode);
        currentNode = newNode;
      } else {
        currentNode = currentNode.children.get(letter);
      }
    }
    currentNode.isTerminal = true;
    currentNode.someValue = value;
  }

  public void printMe() {
    List<Node> currentPath = new ArrayList<Node>();
    currentPath.add(root);
    printMe(currentPath, "");
  }

  // DFS
  public void printMe(List<Node> currentPath, String indent) {
    Node currentNode = currentPath.get(currentPath.size() - 1);
    if (currentNode.isTerminal) {
      String word = "";
      for (Node node : currentPath)
        word += node.letter;
      System.out.println(indent + word + ": " + currentNode.someValue);
      indent += " ";
    }
    for (Node node : currentNode.children.values()) {
      List<Node> newPath = new ArrayList<Node>();
      newPath.addAll(currentPath);
      newPath.add(node);
      printMe(newPath, indent);
    }
  }

  private class Node {
    char letter;
    public boolean isTerminal;
    public Map<Character, Node> children;
    String someValue;

    public Node() {
      this.isTerminal = false;
      this.children = new HashMap<Character, Node>();
    }

    public Node(char letter) {
      this.letter = letter;
      this.isTerminal = false;
      this.children = new HashMap<Character, Node>();
    }
  }

  public static void main(String[] args) {
    Trie trie = new Trie();
    trie.putItem("author", "bla");
    trie.putItem("authority", "bla");
    trie.putItem("authorization", "bla");
    trie.putItem("authot", "bla");
    trie.putItem("aut", "bla");
    trie.putItem("aurora", "bla");
    trie.putItem("aur", "bla");
    trie.putItem("aurors", "bla");

    trie.printMe();

    System.out.println();
    System.out.println("authorization: " + trie.contains("authorization"));
    System.out.println("author: " + trie.contains("author"));
    System.out.println("nyanyan: " + trie.contains("nyanyan"));
  }

}
