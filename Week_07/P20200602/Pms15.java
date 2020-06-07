package leetcode2.P20200602;

/**
 * https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 * Created by yuchen.wu on 2020-06-02
 */

public class Pms15 {

    public int hammingWeight(int n) {
        int count = 0;
        int flag = 1;
        while (flag != Integer.MIN_VALUE) {
            if ((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        if ((n & flag) != 0) {
            count++;
        }
        return count;
    }

    public int hammingWeight2(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >>> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Pms15().hammingWeight(Integer.MIN_VALUE));
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
        System.out.println(Integer.MIN_VALUE & Integer.MIN_VALUE);
    }

}
