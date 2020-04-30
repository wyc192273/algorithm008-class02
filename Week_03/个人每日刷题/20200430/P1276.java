package leetcode.P20200430;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yuchen.wu on 2020-04-30
 */

public class P1276 {

    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {

        if (tomatoSlices % 2 != 0) {
            return new ArrayList<>();
        }
        if (tomatoSlices / 2 < cheeseSlices) {
            return new ArrayList<>();
        }
        if (tomatoSlices / 2 == cheeseSlices) {
            return Arrays.asList(0, tomatoSlices / 2);
        }
        if (tomatoSlices / 4 == cheeseSlices) {
            return Arrays.asList(tomatoSlices / 4, 0);
        }
        for (int i = 1; i <= tomatoSlices / 2; i++) {
            int lastCheese = cheeseSlices - i;
            int lastTomato = tomatoSlices - i * 2;
            if (lastTomato / 4 == lastCheese && lastTomato % 4 == 0) {
                return Arrays.asList(lastTomato / 4, i);
            }
        }
        return new ArrayList<>();
    }

}
