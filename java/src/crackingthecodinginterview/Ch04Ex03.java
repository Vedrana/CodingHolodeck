package crackingthecodinginterview;

/**
 * Given a sorted (increasing order) array, write an algorithm to create a binary tree
 * with minimal height.
 * 
 * @author vedrana
 *
 */
public class Ch04Ex03 {

	public Node addToTree(int[] array, int start, int end) {
		if (end < start) {
			return null;
		}
		int middle = (start + end) / 2;
		Node node = new Node(array[middle]);
		node.left = addToTree(array, start, middle - 1);
		node.right = addToTree(array, middle + 1, end);
		return node;
	}
	
	public Node createTree(int[] array) {
		return addToTree(array, 0, array.length-1);
	}
	
	
	class Node {
		public int value;
		public Node left;
		public Node right;
		
		public Node(int value) {
			this.value = value;
		}
	}
	
	public static void main(String[] args) {
		int[] array = new int[]{1, 2, 3, 4, 5};
		Ch04Ex03.Node node = new Ch04Ex03().createTree(array);
		System.out.println(node.value);

	}

}
