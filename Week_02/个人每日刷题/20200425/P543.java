package leetcode.P20200425;

import leetcode.TreeNode;

/**
 * Created by yuchen.wu on 2020-04-25
 */

public class P543 {

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        deep(root);
        return max;
    }

    private int deep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = deep(root.left);
        int right = deep(root.right);
        if (left + right + 1 > max) {
            max = left + right;
        }
        return Math.max(left, right) + 1;
    }
}
