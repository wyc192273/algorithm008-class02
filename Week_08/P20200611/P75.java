package leetcode2.P20200611;

/**
 * Created by yuchen.wu on 2020-06-11
 */

public class P75 {

    public void sortColors(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        for (int k = 0; k <= j;) {
            if (nums[k] == 0) {
                if (nums[k] == nums[i]) {
                    k++;
                    i++;
                } else {
                    int temp = nums[i];
                    nums[i++] = nums[k];
                    nums[k] = temp;
                }
            } else if (nums[k] == 2) {
                int temp = nums[j];
                nums[j--] = nums[k];
                nums[k] = temp;
            } else {
                k++;
            }
        }
    }

    public static void main(String[] args) {
        new P75().sortColors(new int[] {2,0,2,1,1,0});
    }

}
