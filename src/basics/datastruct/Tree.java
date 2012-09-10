package basics.datastruct;

import java.util.ArrayList;
import java.util.List;

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
					Node<T> result =findNodeDFS(node, child);
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
	
	public class Node<S extends Comparable<S>> {
		private S value;
		private List<Node<S>> children;
		
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
		
		tree.printDFS();		
	}

}
