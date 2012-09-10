package basics.datastruct;

public class BinarySearchTree<T extends Comparable<T>> {

	private Node<T> root;
	
	public BinarySearchTree() {
	}
	
	public void add(T element) throws IllegalArgumentException {
		Node<T> elementNode = new Node<T>(element);
		if (root == null) {
			root = elementNode;
		} else {
			add (elementNode, root);
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Depth: " + bst.depth());
		System.out.println("There " + (bst.contains(8)? "is" : "isn't") +" an 8 in the tree");
		System.out.println("There " + (bst.contains(23)? "is" : "isn't") +" a 23 in the tree");
	}
}

