package leetcode.P20200507;

import leetcode.TreeNode;

/**
 * https://leetcode-cn.com/problems/longest-univalue-path/
 * Created by yuchen.wu on 2020-05-07
 */

public class P687 {

    int result = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        result = Math.max(longestUnivaluePath(root, 0), result);
        return result;
    }

    private int longestUnivaluePath(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }
        //左子树最大的长度路径
        int left = longestUnivaluePath(root.left, root.val);
        //右子树最大的长度路径
        int right = longestUnivaluePath(root.right, root.val);
        //result 和左右长度路径相加 为什么相加？因为结果返回的肯定是和当前节点val相同的长度路径，如果不同就为0了
        result = Math.max(result, left + right);
        // 如果当前节点值和父节点值相同， 则 返回左右子树最大的长度路径+1， 否则返回0
        if (val == root.val) {
            return Math.max(left, right) + 1;
        } else {
            return 0;
        }
    }

}
