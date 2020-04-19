package leetcode.P20200419;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 * Created by yuchen.wu on 2020-04-19
 */

public class P20 {

    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (isRightC(c)) {
                if (stack.isEmpty() || !match(stack.pop(), c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    private boolean match(char c1, char c2) {
        if (c1 == '(' && c2 == ')') {
            return true;
        }
        if (c1 == '{' && c2 == '}') {
            return true;
        }
        if (c1 == '[' && c2 == ']') {
            return true;
        }
        return false;
    }

    private boolean isRightC(char c) {
        if (c == ')' || c == ']' || c == '}') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        new P20().isValid("{[]}");
    }
}
