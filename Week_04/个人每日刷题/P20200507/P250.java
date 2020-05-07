package leetcode.P20200507;

import leetcode.TreeNode;

/**
 * https://leetcode-cn.com/problems/count-univalue-subtrees/
 * Created by yuchen.wu on 2020-05-07
 */

public class P250 {

    int count = 0;

    public int countUnivalSubtrees(TreeNode root) {
        countUnivalSubtreesHelp(root, 0);
        return count;
    }

    public boolean countUnivalSubtreesHelp(TreeNode root, int val) {
        if (root == null) {
            return true;
        }
        if (!countUnivalSubtreesHelp(root.left, root.val) | !countUnivalSubtreesHelp(root.right, root.val)) {
            return false;
        }
        count++;
        return root.val == val;
    }

    public int countUnivalSubtrees2(TreeNode root) {
        countUnivalSubtreesHelp(root);
        return count;
    }

    public Integer countUnivalSubtreesHelp(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            count++;
            return root.val;
        }
        if (root.left != null && root.right != null) {
            Integer left = countUnivalSubtreesHelp(root.left);
            Integer right = countUnivalSubtreesHelp(root.right);
            if (left == null || !left.equals(right) || !left.equals(root.val)) {
                return null;
            }
            count++;
            return left;
        } else if (root.left != null) {
            Integer left = countUnivalSubtreesHelp(root.left);
            if (left == null || !left.equals(root.val)) {
                return null;
            }
            count++;
            return left;
        } else {
            Integer right = countUnivalSubtreesHelp(root.right);
            if (right == null || !right.equals(root.val)) {
                return null;
            }
            count++;
            return right;
        }
    }

}
