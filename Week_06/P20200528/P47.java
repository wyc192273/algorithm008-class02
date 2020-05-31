package leetcode.P20200528;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/permutations-ii/
 * Created by yuchen.wu on 2020-05-28
 */

public class P47 {

    /**
     * 看索引位置的数是否被使用
     */
    boolean[] used ;
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }

        used = new boolean[nums.length];
        List<List<Integer>> result = new ArrayList<>();
        permuteUnique(0, nums, new ArrayList<>(), result);
        return result;
    }

    public void permuteUnique(int i, int[] nums, List<Integer> line, List<List<Integer>> result) {
        if (i == nums.length) {
            result.add(new ArrayList<>(line));
            return;
        }
        //看当前层是否重复使用相同的num ，set是为了防止如下情况
        /**
         *    1     1 (这种相当于重复计算)
         *   / \   / \
         *
         */
        Set<Integer> set = new HashSet<>();
        for (int k = 0; k < nums.length; k++) {
            if (used[k]) {
                continue;
            }
            int num = nums[k];
            if (set.contains(num)) {
                continue;
            }
            set.add(num);
            used[k] = true;
            line.add(num);
            permuteUnique(i + 1, nums, line, result);
            line.remove(line.size() - 1);
            used[k] =false;
        }
    }

}
