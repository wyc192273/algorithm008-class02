package leetcode.P20200421;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 * Created by yuchen.wu on 2020-04-21
 */

public class P350 {

    /**
     * 时间复杂度： O(n)
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> numCounter = new HashMap<>();
        for (int i : nums1) {
            int count = numCounter.getOrDefault(i, 0) + 1;
            numCounter.put(i, count);
        }
        Map<Integer, Integer> result = new HashMap<>();
        int resultCount = 0;
        for (int i : nums2) {
            Integer count = numCounter.get(i);
            if (count != null && count > 0) {
                count--;
                numCounter.put(i, count);
                int rec = result.getOrDefault(i, 0) + 1;
                result.put(i, rec);
                resultCount++;
            }
        }
        int[] resultArray = new int[resultCount];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                resultArray[index++] = entry.getKey();
            }
        }
        return resultArray;
    }

}
