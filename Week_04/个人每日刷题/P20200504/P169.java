package leetcode.P20200504;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/majority-element/description/
 * Created by yuchen.wu on 2020-05-04
 */

public class P169 {

    public int majorityElement(int[] nums) {
        int major = 0;
        int count = 0;
        for (int i : nums) {
            if (count == 0) {
                major = i;
            }
            if (major == i) {
                count++;
            } else {
                count--;
            }
        }
        return major;
    }

}
