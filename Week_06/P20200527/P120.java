package leetcode.P20200527;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;

/**
 * https://leetcode-cn.com/problems/triangle/description/
 * Created by yuchen.wu on 2020-05-27
 */

public class P120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
            }
        }
        return triangle.get(0).get(0);
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int[] dp = new int[triangle.size()];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = triangle.get(triangle.size() - 1).get(i);
        }
        int j = dp.length - 2;
        while (j >= 0) {
            for (int i = 0; i <= j; i++) {
                dp[i] = Math.min(dp[i], dp[i + 1]) + triangle.get(j).get(i);
            }
            j--;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Lists.newArrayList(2));
        list.add(Lists.newArrayList(3,4));
        list.add(Lists.newArrayList(6,5,7));
        list.add(Lists.newArrayList(4,1,8,3));
        System.out.println(new P120().minimumTotal(list));
    }
}
