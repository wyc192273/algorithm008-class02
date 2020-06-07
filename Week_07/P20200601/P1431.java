package leetcode2.P20200601;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/kids-with-the-greatest-number-of-candies/
 * Created by yuchen.wu on 2020-06-01
 */

public class P1431 {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList<>(candies.length);
        int max = 0;
        for (int candie : candies) {
            max = Math.max(max, candie);
        }
        for (int candie : candies) {
            if (max <= extraCandies + candie) {
                list.add(true);
            } else {
                list.add(false);
            }
        }
        return list;
    }

}
