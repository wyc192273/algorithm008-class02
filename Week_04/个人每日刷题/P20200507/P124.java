package leetcode.P20200507;

import leetcode.TreeNode;

/**
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 * Created by yuchen.wu on 2020-05-07
 */

public class P124 {

    int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathSumHelp(root);
        return result;
    }

    private Integer maxPathSumHelp(TreeNode root) {
        if (root == null) {
            return null;
        }
        Integer left = maxPathSumHelp(root.left);
        Integer right = maxPathSumHelp(root.right);
        int max = root.val;
        int sum = root.val;
        if (left != null) {
            sum += left;
            max = Math.max(max, root.val + left);
        }
        if (right != null) {
            sum += right;
            max = Math.max(max, root.val + right);
        }
        result = Math.max(result, Math.max(max, sum));
        return max;
    }

}
