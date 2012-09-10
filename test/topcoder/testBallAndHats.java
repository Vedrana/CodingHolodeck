package topcoder;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import topcoder.BallAndHats;

public class testBallAndHats {

	private BallAndHats ballAndHats;

	@Before
	public void init() {
		ballAndHats = new BallAndHats();
	}

	@Test
	public void testGetHat() {
		assertEquals(ballAndHats.getHat(".o.", 1), 0);
		assertEquals(ballAndHats.getHat("..o", 0), 2);
		assertEquals(ballAndHats.getHat("o..", 1), 1);
		assertEquals(ballAndHats.getHat("..o", 2), 0);
		assertEquals(ballAndHats.getHat("o..", 101), 1);
	}

}
