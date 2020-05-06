package leetcode.P20200504;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/subsets/
 * Created by yuchen.wu on 2020-05-04
 */

public class P78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        subsets(0, result, new ArrayList<>(), nums);
        return result;
    }

    private void subsets(int index, List<List<Integer>> result, List<Integer> list, int[] nums) {
        if (index == nums.length) {
            return;
        }
        subsets(index + 1, result, list, nums);
        list.add(nums[index]);
        result.add(new ArrayList<>(list));
        subsets(index + 1, result, list, nums);
        list.remove(list.size() - 1);
    }
}
