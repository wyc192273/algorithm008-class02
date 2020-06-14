package leetcode2.P20200610;

/**
 * https://leetcode-cn.com/problems/relative-sort-array/
 * Created by yuchen.wu on 2020-06-10
 */

public class P1122 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        if (arr1.length == 0) {
            return new int[0];
        }
        int[] result = new int[arr1.length];
        int[] nums = new int[1001];
        for (int a : arr1) {
            nums[a]++;
        }
        int index = 0;
        for (int a : arr2) {
            while (nums[a]-- > 0){
                result[index++] = a;
            }
        }
        for (int i = 0; i < 1001; i++) {
            while (nums[i]-- > 0) {
                result[index++] = i;
            }
        }
        return result;
    }

}
