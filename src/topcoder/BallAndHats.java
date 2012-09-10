package topcoder;

/**
 * http://community.topcoder.com/stat?c=problem_statement&pm=11964
 * @author vedrana
 *
 */
public class BallAndHats {

	/**
	 * @param hats exactly three characters, two '.' characters and one 'o' character
	 * @param numSwaps between 0 and 1000, inclusive
	 * @return number of the spot that is most likely to contain the ball at the end of the game.
	 * If multiple spots are tied for the largest probability, return the smallest one of them
	 */
	public int getHat(String hats, int numSwaps) {
		int oIndex = hats.indexOf("o");
		if (numSwaps == 0) {
			return oIndex;
		} else {
			if (oIndex == 0 || oIndex == 2) {
				return getHat(".o.", numSwaps - 1);
			} else {
				return getHat("o..", numSwaps - 1);
			}
		}		
	}
}
