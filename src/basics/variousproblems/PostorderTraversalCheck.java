package basics.variousproblems;

import java.util.Arrays;

/**
 * Determine whether an input array is a post-order traversal
 * sequence of a binary tree or not. If it is, return true;
 * otherwise return false. Assume all numbers in an input array are unique.
 * <br/><br/>
 * http://codercareer.blogspot.com/2011/09/no-06-post-order-traversal-sequences-of.html
 */
public class PostorderTraversalCheck {

	public boolean isBST(int[] traversal) {
		if (traversal.length == 0)
			return true;
		int root = traversal[traversal.length - 1];
		
		int i = 0;
		// left subtree, values are smaller than root
		for (; i < traversal.length - 1; i++) {
			if (traversal[i] > root)
				break;
		}
		
		int j = i;
		// right subtree
		for (; j < traversal.length - 1; j++) {
			if (traversal[j] < root)
				return false; // all values in the right subtree should be bigger than root
		}
		
		boolean leftSubtreeIsBST = (i == 0 ? true : isBST(Arrays.copyOfRange(traversal, 0, i)));
		boolean rightSubtreeIsBST = isBST(Arrays.copyOfRange(traversal, i, traversal.length - 1));
		// it would probably be better to replace expensive copyOfRange with start and end indices and arrayLength info 
		
		return leftSubtreeIsBST && rightSubtreeIsBST;
	}
	
	public static void main(String[] args) {
		PostorderTraversalCheck travCheck = new PostorderTraversalCheck();
		
		int[] traversal = new int[] {5, 7, 6, 9, 11, 10, 8};
		System.out.println(travCheck.isBST(traversal)); // true
		int[] notTraversal = new int[] {7, 4, 6, 5};
		System.out.println(travCheck.isBST(notTraversal)); // false
	}

}
