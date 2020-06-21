package leetcode2.P20200618;

import java.util.Stack;

import leetcode.P20200307.P102;
import leetcode.TreeNode;

/**
 * https://leetcode-cn.com/problems/recover-a-tree-from-preorder-traversal/
 * Created by yuchen.wu on 2020-06-18
 */

public class P1028 {

    public TreeNode recoverFromPreorder(String S) {
        if (S == null || S.length() == 0) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        char[] chars = S.toCharArray();
        int curLevel = 0;
        for (int i = 0; i < S.length(); ) {
            curLevel = 0;
            while (chars[i] == '-') {
                i++;
                curLevel++;
            }
            int start = i;
            while (i < S.length() && chars[i] != '-') {
                i++;
            }
            int num = Integer.parseInt(S.substring(start, i));
            TreeNode treeNode = new TreeNode(num);
            if (stack.isEmpty()) {
                stack.push(treeNode);
                continue;
            }
            while (stack.size() > curLevel) {
                stack.pop();
            }
            TreeNode parent = stack.peek();
            if (parent.left != null) {
                parent.right = treeNode;
            } else {
                parent.left = treeNode;
            }
            stack.push(treeNode);
        }
        return stack.firstElement();
    }

    public TreeNode recoverFromPreorder2(String S) {
        if (S == null || S.length() == 0) {
            return null;
        }

        int next = S.indexOf("-");
        TreeNode treeNode = new TreeNode(getNumber(S, 0, next));
        recoverFromPreorder(treeNode, 1, S, 0);
        return treeNode;
    }

    public int recoverFromPreorder(TreeNode root, int level, String S, int rootIndex) {
        String str = getStr(level);
        int leftIndex = S.indexOf(str, rootIndex);
        if (leftIndex == -1) {
            return rootIndex;
        }
        int next = S.indexOf("-", leftIndex + level);
        if (next == -1) {
            root.left = new TreeNode(getNumber(S, leftIndex + level, S.length()));
        } else {
            root.left = new TreeNode(getNumber(S, leftIndex + level, next));
        }
        int leftEnd = recoverFromPreorder(root.left, level + 1, S, leftIndex);
        if (next == -1) {
            return -1;
        }
        int rightIndex = next;
        next = S.indexOf("-", rightIndex + level);
        if (next == -1) {
            root.right = new TreeNode(getNumber(S, rightIndex + level, S.length()));
        } else {
            root.right = new TreeNode(getNumber(S, rightIndex + level, next));
        }
        int rightEnd = recoverFromPreorder(root.right, level + 1, S, rightIndex);
        return rightEnd;
    }

    private String getStr(int level) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < level; i++) {
            stringBuilder.append('-');
        }
        return stringBuilder.toString();
    }

    private int getNumber(String s, int start, int end) {
        return Integer.parseInt(s.substring(start, end));
    }

    public static void main(String[] args) {
        new P1028().recoverFromPreorder("1-2--3--4-5--6--7");
    }

}
