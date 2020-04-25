package leetcode.P20200425;

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 * Created by yuchen.wu on 2020-04-25
 */

public class Pms51 {

    /**
     * 归并 O(nlogn)
     * 分割的时候对于mid的计算有一个注意点
     * 如果我们用 mid = l + (h - l) / 2 来计算的话
     * 右边mergeSort(nums, mid, h);会导致一直递归，无法触发l >= h
     * 主要原因是，mid = l + (h - l) / 2 这种计算的是mid落在左侧，比如 l = 2, h = 3的时候
     * 这时候计算，mid 会一直等于2，然后 在mergeSort(nums, mid, h); 调用无限递归下去
     * 所以 这里如果要是
     * mergeSort(nums, l, mid - 1);
     * mergeSort(nums, mid, h);
     * 则 mid 需要 = l + (h - l + 1) / 2 ， 使得mid落在右侧，这个时候 l = 2, h = 3的时候，mid = 3， 下次调用会正常触发结束条件
     *
     * 如果想要使用
     * mid = l + (h - l) / 2
     * 则 mergeSort需要这么写
     * mergeSort(nums, l, mid);
     * mergeSort(nums, mid + 1, h);
     *
     */
    int result = 0;
    public int reversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return result;
    }

    private void mergeSort(int[] nums, int l, int h) {
        if (l >= h) {
            return;
        }
        int mid = l + (h - l + 1) / 2;
        mergeSort(nums, l, mid - 1);
        mergeSort(nums, mid, h);
        merge(nums, l, mid, h);
    }

    private void merge(int[] nums, int l, int mid, int h) {
        int left = l;
        int right = mid;
        int[] newArray = new int[h - l + 1];
        int index = 0;
        while (left < mid && right <= h) {
            if (nums[left] <= nums[right]) {
                newArray[index++] = nums[left++];
            } else {
                result += mid - left;
                newArray[index++] = nums[right++];
            }
        }
        while (left < mid) {
            newArray[index++] = nums[left++];
        }
        while (right <= h) {
            newArray[index++] = nums[right++];
        }
        index = 0;
        for (; index < newArray.length; index++) {
            nums[index + l] = newArray[index];
        }
    }

    public static void main(String[] args) {
        new Pms51().reversePairs(new int[] { 7, 5, 6, 4 });
    }

    /**
     * 暴力 O(n^2)
     */
    public int reversePairs2(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return 0;
        }
        int left = 0;
        int right = left + 1;
        int result = 0;
        while (left < nums.length - 1) {
            while (right < nums.length) {
                if (nums[left] > nums[right]) {
                    result++;
                }
                right++;
            }
            left++;
            right = left + 1;
        }
        return result;
    }



}
