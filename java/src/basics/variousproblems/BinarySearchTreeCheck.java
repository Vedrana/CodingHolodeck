package basics.variousproblems;

/**
 * Given a binary tree, check whether it�s a binary search tree or not.
 *
 * @author vedrana
 */
public class BinarySearchTreeCheck {

  private class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }
  }

  public boolean checkBST(Node root) {
    if (root == null)
      return true;
    if (root.left != null && root.right != null)
      if (root.left.value >= root.value || root.right.value <= root.value)
        return false;

    int min = -(int) Math.pow(2, 31);
    int max = (int) Math.pow(2, 31) - 1;

    return checkBST(root, min, max);
  }

  private boolean checkBST(Node node, int min, int max) {
    if (node == null)
      return true;
    if (!(node.value > min && node.value < max))
      return false;
    return checkBST(node.left, min, node.value) && checkBST(node.right, node.value, max);
  }


  public static void main(String[] args) {
    BinarySearchTreeCheck bstChck = new BinarySearchTreeCheck();

    Node one = bstChck.new Node(1);
    Node four = bstChck.new Node(4);
    Node two = bstChck.new Node(2);
    two.left = one;
    two.right = four;
    Node five = bstChck.new Node(5);
    Node three = bstChck.new Node(3);
    three.left = two;
    three.right = five;

    System.out.println(bstChck.checkBST(three)); // should be false

  }

}
