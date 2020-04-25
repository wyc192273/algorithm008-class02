package leetcode.P20200424;

import leetcode.TreeNode;

/**
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 * Created by yuchen.wu on 2020-04-24
 */

public class P110 {

    boolean balance = true;
    /**
     * DFS
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        high(root);
        return balance;
    }

    private int high(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHigh = high(root.left) + 1;
        int rightHigh = high(root.right) + 1;
        if (Math.abs(leftHigh - rightHigh) > 1) {
            balance = false;
        }
        return Math.max(leftHigh, rightHigh) ;
    }

    public static void main(String[] args) {
        new P110().isBalanced(TreeNode.generate(new Integer[] { 3, 9, 20, null, null, 15, 7 }));
    }

}
