package leetcode2.P20200615;

/**
 * https://leetcode-cn.com/problems/reverse-pairs/
 * Created by yuchen.wu on 2020-06-15
 */

public class P493 {

    int res = 0;

    public int reversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return res;
    }

    private void mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        count(nums, l, mid, r);
        merge(nums, l, mid, r);
    }

    private void count(int[] nums, int l, int mid, int r) {
        int j = mid + 1;
        for (int i = l; i <= mid; i++) {
            while (j <= r && (((long)nums[i]) - ((long)nums[j])) > (long)nums[j]) {
                j++;
            }
            res += (j - mid - 1);
        }
    }

    private void merge(int[] nums, int l, int mid, int r) {
        int i = l;
        int j = mid + 1;
        int[] newNums = new int[r - l + 1];
        int index = 0;
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) {
                newNums[index++] = nums[i++];
            } else {
                newNums[index++] = nums[j++];
            }
        }
        while (i <= mid) {
            newNums[index++] = nums[i++];
        }
        while (j <= r) {
            newNums[index++] = nums[j++];
        }
        for (index = 0; index < newNums.length; index++) {
            nums[index + l] = newNums[index];
        }
    }

}
