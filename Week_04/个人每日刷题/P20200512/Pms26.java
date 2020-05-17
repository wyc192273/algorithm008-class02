package leetcode.P20200512;

import leetcode.TreeNode;

/**
 * https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
 * Created by yuchen.wu on 2020-05-12
 */

public class Pms26 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return A != null && B != null ? isSub(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B) : false;
    }

    private boolean isSub(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null) {
            return false;
        }
        if (A.val == B.val) {
            return isSub(A.left, B.left) && isSub(A.right, B.right);
        } else {
            return false;
        }
    }

}
