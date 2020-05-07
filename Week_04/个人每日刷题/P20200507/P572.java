package leetcode.P20200507;

import leetcode.TreeNode;

/**
 * https://leetcode-cn.com/problems/subtree-of-another-tree/
 * Created by yuchen.wu on 2020-05-07
 */

public class P572 {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null) {
            return false;
        }
        return isSubtreeHelp(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSubtreeHelp(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val == t.val) {
            return isSubtreeHelp(s.left, t.left) && isSubtreeHelp(s.right, t.right);
        } else {
            return false;
        }
    }

}
