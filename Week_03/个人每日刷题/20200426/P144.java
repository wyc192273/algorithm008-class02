package leetcode.P20200426;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import leetcode.TreeNode;

/**
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * Created by yuchen.wu on 2020-04-26
 */

public class P144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            result.add(treeNode.val);
            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }
            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }
        }
        return result;
    }

    List<Integer> result = new ArrayList<>();
    public List<Integer> preorderTraversal2(TreeNode root) {
        if (root == null) {
            return result;
        }
        result.add(root.val);
        preorderTraversal2(root.left);
        preorderTraversal2(root.right);
        return result;
    }

}
