package leetcode2.P20200614;

/**
 * https://leetcode-cn.com/problems/merge-sorted-array/
 * Created by yuchen.wu on 2020-06-14
 */

public class P88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int index = nums1.length - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] <= nums2[j]) {
                nums1[index--] = nums2[j--];
            } else {
                nums1[index--] = nums1[i--];
            }
        }
        while (j>=0) {
            nums1[index--] = nums2[j--];
        }
    }
}
