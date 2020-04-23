package leetcode.P20200422;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/remove-outermost-parentheses/
 * Created by yuchen.wu on 2020-04-22
 */

public class P1021 {

    public String removeOuterParentheses(String S) {
        char[] chars = S.toCharArray();
        Stack<Character> characterStack = new Stack<>();
        boolean first = true;
        StringBuilder result = new StringBuilder();
        for (char c : chars) {
            if (first && c == '(') {
                first = false;
            } else if (c == ')' && characterStack.isEmpty()) {
                first = true;
            } else if (c == '(') {
                result.append('(');
                characterStack.push(')');
            } else if (c == ')') {
                result.append(')');
                characterStack.pop();
            }
        }
        return result.toString();
    }

    public String removeOuterParentheses2(String S) {
        char[] chars = S.toCharArray();
        int count = 0;
        StringBuilder result = new StringBuilder();
        for (char c : chars) {
            if (c == '(') {
                if (count++ > 0) {
                    result.append('(');
                }
            } else {
                if (--count > 0) {
                    result.append(')');
                }
            }
        }
        return result.toString();
    }


}
