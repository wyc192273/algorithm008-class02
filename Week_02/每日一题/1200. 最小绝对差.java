package leetcode.P20200425;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/minimum-absolute-difference/
 * Created by yuchen.wu on 2020-04-25
 */

public class P1200 {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        int minSub = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int nowSub = Math.abs(arr[i] - arr[i - 1]);
            if (nowSub == minSub) {
                result.add(Arrays.asList(arr[i - 1], arr[i]));
            } else if(nowSub < minSub){
                minSub = nowSub;
                result = new ArrayList<>();
                result.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }
        return result;
    }

}
