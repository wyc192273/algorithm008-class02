package leetcode.P20200529;

/**
 * https://leetcode-cn.com/problems/number-of-segments-in-a-string/
 * Created by yuchen.wu on 2020-05-29
 */

public class P434 {

    public int countSegments(String s) {
        char[] chars = s.toCharArray();
        int l = 0;
        int r = 0;
        int count = 0;
        while (r <= chars.length) {
            if (r == chars.length || chars[r] == ' ') {
                if (l != r && chars[l] != ' ') {
                    count++;
                    l = r;
                }
            } else {
                l = r;
            }
            r++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE + 1);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MIN_VALUE - 1);
        System.out.println(Integer.MAX_VALUE);
    }
}
