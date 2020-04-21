package leetcode.P20200421;

/**
 * https://leetcode-cn.com/problems/is-subsequence/
 * Created by yuchen.wu on 2020-04-21
 */

public class P392 {

    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        int left = 0;
        int right = 0;
        while (left < s.length() && right < t.length()) {
            if (s.charAt(left) == t.charAt(right)) {
                left++;
            }
            right++;
        }
        return left == s.length();
    }

    /**
     *  对于如果有多个s的话，缓存一下t的字符串位置信息
     *
     */
    public boolean isSubsequence2(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        //二维数组 第一维是t中索引位置， 第二维是26个字母， 对应的值代表 在该索引位置 对应的字符在之后哪个索引位置出现
        int[][] charIndex = new int[t.length() + 1][26];
        char[] tChars = new char[t.length() + 1];
        System.arraycopy(t.toCharArray(), 0, tChars, 1, t.length());
        //这里前面加一个空字符是防止 abc情况，这里a的位置下一位实际上是-1，这时候和ab 匹配会有问题
        //而加个空格的话，我们会错一位相当于 " abc"
        //例子 {{1,2,3}, {-1,2,3}, {-1,-1,3}, {-1,-1,-1}}
        //这样ab过来的时候可以正确匹配
        tChars[0] = ' ';
        //这个循环用来记录 每个位置对应不同字符的下一位出现位置
        for (int i = 0; i < 26; i++) {
            //刚开始-1初始化
            int nextPos = -1;
            for (int j = tChars.length - 1; j >= 0; j--) {
                charIndex[j][i] = nextPos;
                //如果当前位置与要计算的字符相同，则当前位置是前面索引位置当前字符的下一个出现的位置
                if (tChars[j] == 'a' + i) {
                    nextPos = j;
                }
            }
        }
        int index = 0;
        for (char c : s.toCharArray()) {
            index = charIndex[index][c - 'a'];
            if (index == -1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new P392().isSubsequence2("abc", "abc");
    }
}
