package topcoder;

import java.util.HashMap;
import java.util.Map;

// SRM 548 div 2
public class KingdomAndDucks {

    public int minDucks(int[] duckTypes) {

        Map<Integer, Integer> ducks = new HashMap<Integer, Integer>();

        for (int i = 0; i < duckTypes.length; i++) {
            Integer duck = new Integer(duckTypes[i]);
            if (!ducks.containsKey(duck))
                ducks.put(duck, 1);
            else
                ducks.put(duck, ducks.get(duck) + 1);
        }
        int maxNum = 0;
        int types = ducks.keySet().size();
        for (Integer val : ducks.values()) {
            if (val > maxNum)
                maxNum = val;
        }

        return types * maxNum;

    }

}