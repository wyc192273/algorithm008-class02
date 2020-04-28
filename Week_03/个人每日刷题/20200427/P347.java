package leetcode.P20200427;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 * Created by yuchen.wu on 2020-04-27
 */

public class P347 {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            int count = map.getOrDefault(i, 0) + 1;
            map.put(i, count);
        }
        List<Integer>[] result = new ArrayList[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (result[entry.getValue()] == null) {
                result[entry.getValue()] = new ArrayList<>();
            }
            result[entry.getValue()].add(entry.getKey());
        }
        int index = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = result.length - 1; i >= 0; i--) {
            if (index == k) {
                break;
            }
            if (result[i] == null) {
                continue;
            }
            index += result[i].size();
            ans.addAll(result[i]);
        }
        int[] ansA = new int[ans.size()];
        for (int i = 0; i < ansA.length; i++) {
            ansA[i] = ans.get(i);
        }
        return ansA;
    }

    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            int count = map.getOrDefault(i, 0) + 1;
            map.put(i, count);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, Comparator.comparingInt(map::get));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (queue.size() < k) {
                queue.add(entry.getKey());
            } else {
                if (map.get(queue.peek()) < entry.getValue()) {
                    queue.poll();
                    queue.offer(entry.getKey());
                }
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = queue.poll();
        }
        return ans;
    }

}
