package leetcode.P20200413;

import leetcode.TreeNode;

/**
 * 题目链接：https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 * Created by yuchen.wu on 2020-04-13
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 */

public class Pms68II {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        }
        return root;
    }
}
