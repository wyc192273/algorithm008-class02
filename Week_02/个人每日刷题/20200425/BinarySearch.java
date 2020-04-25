package leetcode.P20200425;

/**
 * Created by yuchen.wu on 2020-04-25
 */

public class BinarySearch {

    public int searchFirstEquals(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (nums[left] == k) {
            return left;
        }
        return -1;
    }

    public int searchFirstLargeOrEquals(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (nums[left] >= k) {
            return left;
        }
        return -1;
    }

    public int searchFirstLessOrEquals(int[] nums, int k) {
//        if (nums == null || nums.length == 0) {
//            return -1;
//        }
//        int left = 0;
//        int right = nums.length - 1;
//        int result = 0;
//        while (left <= right) {
//            int mid = left + (right - left) / 2;
//            if (nums[mid] == k) {
//                if(mid > 0 && nums[mid - 1] == k) {
//                    right = mid - 1;
//                } else {
//                    result = mid;
//                    break;
//                }
//            } else if (nums[mid] < k) {
//                if (mid != nums.length - 1 && nums[mid + 1] > k) {
//                    result = mid;
//                    break;
//                }
//                left = mid + 1;
//            } else {
//                right = mid - 1;
//            }
//        }
//        if (nums[result] == k) {
//            return result;
//        }
//        for (int i = result; i > 0 && nums[i - 1] == nums[i]; i--) {
//
//        }
//        if (nums[result] > k) {
//            return -1;
//        }
        return -1;
    }

    public int searchLastEquals(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] > k) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        if (nums[left] == k) {
            return left;
        }
        return -1;
    }

    public int searchLastLessOrEquals(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] > k) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        if (nums[left] <= k) {
            return left;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 3, 4, 5, 5, 5, 6, 6, 7, 8 };
        System.out.println(new BinarySearch().searchLastEquals(nums, 6));
        System.out.println(new BinarySearch().searchLastEquals(nums, 5));
        System.out.println(new BinarySearch().searchFirstEquals(nums, 6));
        System.out.println(new BinarySearch().searchFirstEquals(nums, 5));
        int[] nums2 = new int[] { 1, 2, 3, 5, 5, 5, 7, 8 };
        System.out.println(new BinarySearch().searchFirstLargeOrEquals(nums2, 6));
        System.out.println(new BinarySearch().searchFirstLargeOrEquals(nums2, 4));
        System.out.println(new BinarySearch().searchFirstLargeOrEquals(nums2, 5));

        System.out.println(new BinarySearch().searchLastLessOrEquals(nums2, 6));
        System.out.println(new BinarySearch().searchLastLessOrEquals(nums2, 4));
        System.out.println(new BinarySearch().searchLastLessOrEquals(nums2, 5));


        System.out.println(new BinarySearch().searchFirstLessOrEquals(nums2, 6));
        System.out.println(new BinarySearch().searchFirstLessOrEquals(nums2, 4));
        System.out.println(new BinarySearch().searchFirstLessOrEquals(nums2, 5));


    }

}
