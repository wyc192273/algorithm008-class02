package leetcode2.P20200621;

import leetcode.TreeNode;

/**
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 * Created by yuchen.wu on 2020-06-21
 */

public class P124 {

    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxPathSumHelp(root);
        return res;
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
        res = Math.max(res, Math.max(max, sum));
        return max;
    }
}
