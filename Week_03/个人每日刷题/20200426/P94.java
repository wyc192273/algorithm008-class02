package leetcode.P20200426;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import leetcode.TreeNode;

/**
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * Created by yuchen.wu on 2020-04-26
 */

public class P94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }

    List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal2(TreeNode root) {
        if (root == null) {
            return result;
        }
        inorderTraversal2(root.left);
        result.add(root.val);
        inorderTraversal2(root.right);
        return result;
    }

}
