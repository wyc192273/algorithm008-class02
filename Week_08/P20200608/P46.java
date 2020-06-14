package leetcode2.P20200608;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by yuchen.wu on 2020-06-08
 */

public class P46 {

    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        used = new boolean[nums.length];
        List<List<Integer>> result = new ArrayList<>();
        permute(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void permute(int i, int[] nums, List<Integer> list, List<List<Integer>> result) {
        if (i == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (used[j]) {
                continue;
            }
            list.add(nums[j]);
            used[j] = true;
            permute(i + 1, nums, list, result);
            used[j] = false;
            list.remove(list.size() - 1);
        }
    }

}
