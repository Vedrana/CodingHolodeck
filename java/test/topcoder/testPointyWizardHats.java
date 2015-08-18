package topcoder;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import topcoder.PointyWizardHats;

public class testPointyWizardHats {

	private PointyWizardHats pointyWizardHats;
	
	@Before
	public void setUp(){
		pointyWizardHats = new PointyWizardHats();
	}

	@Test
	public void testGetNumHats() {
		assertEquals(1, pointyWizardHats.getNumHats(new int[] {30}, new int[] {3}, new int[] {3}, new int[] {30}));
		assertEquals(1, pointyWizardHats.getNumHats(new int[] {4, 4}, new int[] {4, 3}, new int[] {5, 12}, new int[] {5, 4}));
		assertEquals(1, pointyWizardHats.getNumHats(new int[] {3}, new int[] {3}, new int[] {1, 1}, new int[] {2, 4}));
		
		assertEquals(2, pointyWizardHats.getNumHats(new int[] {10, 10}, new int[] {2, 5}, new int[] {2, 9}, new int[] {3, 6}));
		
		assertEquals(36, pointyWizardHats.getNumHats(new int[] {4594, 9402, 168, 4467, 9580, 1284, 9644, 7454, 122, 6146, 5593,
				6656, 7367, 8313, 8820, 6502, 1316, 4835, 5584, 8857, 8113, 2343, 5274, 5135, 1760, 1273, 20, 2280, 4989, 4298,
				3114, 142, 6882, 1283, 9316, 7715, 6758, 57, 274, 2268, 4826, 880}, 
				new int[] {2595, 8463, 157, 2596, 4393,
				4243, 5631, 141, 8586, 6470, 7705, 6374, 7602, 2093, 6071, 5949, 4745, 9960, 4564, 5376, 1982, 4307, 73, 1328,
				2610, 3408, 591, 8774, 9940, 5940, 7061, 1549, 9895, 3161, 6207, 653, 6279, 7215, 3139, 9701, 2337, 4538}, 
				new int[] {3230, 2740, 1196, 8692, 2467, 6943, 796, 8716, 4283, 1581, 5987, 7582, 8748, 5098, 1625, 232, 6928,
				4123, 5704, 2269, 9168, 1824, 806, 8423, 1156, 8128, 5528, 4613, 5704, 1018, 4872, 8610, 1354, 6382, 114, 2110,
				1175, 3684, 4114, 1371, 6398, 6134},
				new int[] {7664, 4466, 9901, 6932, 6084, 690, 3990, 7710, 2986, 1670, 5382,
				1319, 9905, 4343, 7889, 8756, 6306, 3125, 9857, 9225, 4391, 2295, 9147, 3044, 7071, 9917, 3130, 9459, 5482, 1475,
				5002, 5293, 4523, 4781, 564, 5778, 1014, 7712, 1554, 5953, 9289, 6847}));
	}

}
