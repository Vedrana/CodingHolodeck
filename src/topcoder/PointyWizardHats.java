package topcoder;

import java.util.Arrays;

/**
 * http://community.topcoder.com/stat?c=problem_statement&pm=11965
 *  
 * @author vedrana
 *
 */
public class PointyWizardHats {
	
	private int topConesNum;
	int bottomConesNum;
	boolean[][] graph;
	
	int[] leftOf; // leftOf[v] is a vertex on the left that was matched with vertex v on right
	boolean[] seenTop;
	boolean[] seenBottom;
	
	
	public int getNumHats(int[] topHeight, int[] topRadius, int[] bottomHeight, int[] bottomRadius) {		
		topConesNum = topHeight.length;
		bottomConesNum = bottomHeight.length;
		graph = new boolean[topConesNum][bottomConesNum];
		leftOf = new int[bottomConesNum];
		seenTop = new boolean[topConesNum];
		seenBottom = new boolean[bottomConesNum];
		
		for (int t = 0; t < topHeight.length; t++) {
			for (int b = 0; b < bottomHeight.length; b++) {
				graph[t][b] = hatFormingCones(topHeight[t], topRadius[t], bottomHeight[b], bottomRadius[b]);
			}
		}
		return calc();
	}
	
	// search for an alternating path to improve current matching
	private boolean maxBipartMatch(int t) {
		if (seenTop[t]) {
			return false;
		}
		seenTop[t] = true;
		
		for (int b = 0; b < bottomConesNum; b++) {
			if (graph[t][b] && !seenBottom[b]) {
				seenBottom[b] = true;
				if (leftOf[b] == -1 || maxBipartMatch(leftOf[b])) {
					leftOf[b] = t;
					return true;
				}
			}
		}
		return false;
	}
	
	private int calc() {
		Arrays.fill(leftOf, -1);
		int numOfHats = 0;
		for (int i = 0; i < topConesNum; i++) {
			Arrays.fill(seenTop, false);
			Arrays.fill(seenBottom, false);	
			if (maxBipartMatch(i)) {
				numOfHats++;
			}
		}
		return numOfHats;
	}
	
	private boolean hatFormingCones(int topHeight, int topRadius, int bottomHeight, int bottomRadius) {
		return topRadius < bottomRadius && topHeight * bottomRadius > topRadius * bottomHeight;
	}
	
}
