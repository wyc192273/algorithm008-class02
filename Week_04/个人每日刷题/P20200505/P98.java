package leetcode.P20200505;

import java.util.Stack;

import leetcode.TreeNode;

/**
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * Created by yuchen.wu on 2020-05-05
 */

public class P98 {

    /**
     * 中序遍历 迭代方法
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode last = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (last != null && last.val >= root.val) {
                return false;
            }
            last = root;
            root = root.right;
        }
        return true;
    }

    /**
     * 深度搜索
     * @param root
     * @return
     */
    public boolean isValidBST3(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isValidBSTHelp(root, null, null);
    }

    private boolean isValidBSTHelp(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        if (min != null && min.val >= root.val) {
            return false;
        }
        if (max != null && max.val <= root.val) {
            return false;
        }
        return isValidBSTHelp(root.left, min, root) && isValidBSTHelp(root.right, root, max);
    }

    private TreeNode last;
    private boolean result = true;

    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        isValidBSTHelp(root);
        return result;
    }

    private void isValidBSTHelp(TreeNode root) {
        if (root == null) {
            return;
        }
        isValidBSTHelp(root.left);
        if (last != null && last.val >= root.val) {
            result = false;
        }
        last = root;
        isValidBSTHelp(root.right);
    }

}
