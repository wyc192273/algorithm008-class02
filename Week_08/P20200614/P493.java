package leetcode2.P20200614;

/**
 * https://leetcode-cn.com/problems/reverse-pairs/
 * Created by yuchen.wu on 2020-06-14
 */

public class P493 {


    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return 0 ;
        }
        int mid = l + (r - l) / 2;
        int count = mergeSort(nums, l, mid) + mergeSort(nums, mid + 1, r);
        int j = mid + 1;
        for (int i = l; i <= mid; i++) {
            while (j <= r && (((long)nums[i]) - ((long)nums[j])) > (long)nums[j]) {
                j++;
            }
            count += (j - mid - 1);
        }
        merge(nums, l, mid, r);
        return count;
    }

    private void merge(int[] nums, int l, int mid, int r) {
        int i = l;
        int j = mid + 1;
        int[] newNums = new int[r - l + 1];
        int index = 0;
        while (i <= mid || j <= r) {
            if (i > mid) {
                newNums[index++] = nums[j++];
            } else if (j > r) {
                newNums[index++] = nums[i++];
            }else if (nums[i] < nums[j]) {
                newNums[index++] = nums[i++];
            } else {
                newNums[index++] = nums[j++];
            }
        }
        index = 0;
        for (i = 0; i < newNums.length; i++, index++) {
            nums[i + l] = newNums[index];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {-2,-4,-3,-5,-1 };
        System.out.println(new P493().reversePairs(nums));
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

}
