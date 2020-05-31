package leetcode.P20200528;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/decode-string/
 * Created by yuchen.wu on 2020-05-28
 */

public class P394 {

    public String decodeString(String s) {
        Stack<Integer> stack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        char[] chars = s.toCharArray();
        StringBuilder str = new StringBuilder();
        int multi = 0;
        for (char c : chars) {
            if (c == '[') {
                stack.push(multi);
                strStack.push(str.toString());
                multi = 0;
                str = new StringBuilder();
            } else if (c == ']') {
                StringBuilder temp = new StringBuilder();
                int curMulti = stack.pop();
                for (int i = 0; i < curMulti; i++) {
                    temp.append(str);
                }
                str = new StringBuilder(strStack.pop() + temp);
            } else if(c >= '0' && c <= '9') {
                multi = multi * 10 + Integer.parseInt(c + "");
            } else {
                str.append(c);
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        new P394().decodeString("3[a]2[bc]");
    }
}
