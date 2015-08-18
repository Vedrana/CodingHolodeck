package basics.dynprog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A sequence of numbers is called a zig-zag sequence if the differences
 * between successive numbers strictly alternate between positive and negative.
 * The first difference (if one exists) may be either positive or negative. A
 * sequence with fewer than two elements is trivially a zig-zag sequence. <br/><br/>
 * 
 * For example, 1,7,4,9,2,5 is a zig-zag sequence because the differences (6,-3,5,-7,3)
 * are alternately positive and negative. In contrast, 1,4,7,2,5 and 1,7,4,5,5 are not
 * zig-zag sequences, the first because its first two differences are positive and the
 * second because its last difference is zero. <br/><br/>
 * 
 * Given a sequence of integers, sequence, return the length of the longest subsequence
 * of sequence that is a zig-zag sequence. A subsequence is obtained by deleting some
 * number of elements (possibly zero) from the original sequence, leaving the remaining
 * elements in their original order. <br/><br/>
 * 
 * Example: <br/>
 * { 1, 17, 5, 10, 13, 15, 10, 5, 16, 8 } returns: 7 <br/>
 * There are several subsequences that achieve this length. One is 1,17,10,13,10,16,8. <br/>
 * 
 * See <a href="http://community.topcoder.com/tc?module=ProblemDetail&rd=4493&pm=1259">
 * the whole problem statement</a>
 * 
 * @author vjankovic
 *
 */
public class ZigZag {
	
	public static int zigZag(List<Integer> sequence) {
		
		if (sequence.size() < 2) {
			return sequence.size(); 
		}
		
		// zigzag[i] = the length of longest zigzag subsequence for sequence[0:i]
		List<Integer> zigzagLen = new ArrayList<Integer>();
		zigzagLen.add(0, 1);
		
		// zigzagLast[i] = index of last element(s) of zigzag[i]
		List<List<Integer>> lastElemIndex = new ArrayList<List<Integer>>();
		for (int i = 0; i < sequence.size(); i++ ) {
			lastElemIndex.add(i, new ArrayList<Integer>());	
		}
		lastElemIndex.get(0).add(0);		
				
		// info about the last difference in zigzag[i]
		// -1 if the difference is negative, +1 otherwise
		List<Integer> lastDiffSign = new ArrayList<Integer>();
		lastDiffSign.add(0, 0);
		
		int maxZigzag = 1;
		
		// Basic algorithm:
		// If two equal neighbors - nothing changes in comparison to i-1
		// If unequal neighbors:
		//		If zigzag condition satisfied - update zigzag len, last elem index and last diff sign
		//		If zigzag condition not satisfied - only the list of last elem index changes in comparison to i-1 - we add i to it 
		
		for (int i = 1; i < sequence.size(); i++) {			
			// two equal neighbors
			if (sequence.get(i) == sequence.get(i-1)) {
				zigzagLen.add(i, zigzagLen.get(i-1));
				lastElemIndex.get(i).addAll(lastElemIndex.get(i-1));
				lastElemIndex.get(i).add(i);
				lastDiffSign.add(i, lastDiffSign.get(i-1));
				
			} else {
				boolean isZigzag = false;
				for (Integer j : lastElemIndex.get(i-1)) {					
					int diff = sequence.get(i) - sequence.get(j);
					if ((diff > 0 && lastDiffSign.get(i-1) <= 0) || 
						(diff < 0 && lastDiffSign.get(i-1) >= 0)) {
						//zigzag condition satisfied	
						zigzagLen.add(i, zigzagLen.get(i-1)+1);
						lastElemIndex.get(i).add(i);
						lastDiffSign.add(i, diff / Math.abs(diff));
						
						if (zigzagLen.get(i) > maxZigzag) {
							maxZigzag = zigzagLen.get(i); 
						}
						isZigzag = true;
						break;
					}						
					if (!isZigzag){
						//zigzag condition NOT satisfied
						zigzagLen.add(i, zigzagLen.get(i-1));
						lastElemIndex.get(i).addAll(lastElemIndex.get(i-1));
						lastElemIndex.get(i).add(i);
						lastDiffSign.add(i, lastDiffSign.get(i-1));
					}
				}				
			}
		}		
		return maxZigzag;
	}
	
	public static void main(String[] args) {
		List<Integer> sequence = new ArrayList<Integer>();
		sequence.addAll(Arrays.asList(new Integer[] { 1, 7, 4, 9, 2, 1 }));		
		System.out.println(sequence.toString() + " : " + zigZag(sequence));
		
		sequence.clear();
		sequence.addAll(Arrays.asList(new Integer[] { 1, 17, 5, 10, 13, 11, 10 }));		
		System.out.println(sequence.toString() + " : " + zigZag(sequence));
		
		sequence.clear();
		sequence.addAll(Arrays.asList(new Integer[] { 1, 17, 17, 5, 10, 13, 11, 10 }));		
		System.out.println(sequence.toString() + " : " + zigZag(sequence));
		
		sequence.clear();
		sequence.addAll(Arrays.asList(new Integer[] { 1, 2, 3, 4, 5}));		
		System.out.println(sequence.toString() + " : " + zigZag(sequence));
		
		sequence.clear();
		sequence.addAll(Arrays.asList(new Integer[] { 70, 55, 13, 2, 99, 2, 80, 80, 80,
				80, 100, 19, 7, 5, 5, 5, 1000, 32, 32 }));		
		System.out.println(sequence.toString() + " : " + zigZag(sequence));
		
		sequence.clear();
		sequence.addAll(Arrays.asList(new Integer[] { 374, 40, 854, 203, 203, 156, 362,
				279, 812, 955, 600, 947, 978, 46, 100, 953, 670, 862, 568, 188, 67, 669,
				810, 704, 52, 861, 49, 640, 370, 908, 477, 245, 413, 109, 659, 401, 483,
				308, 609, 120, 249, 22, 176, 279, 23, 22, 617, 462, 459, 244 }));
		System.out.println(sequence.toString() + " : " + zigZag(sequence));

	}
}
