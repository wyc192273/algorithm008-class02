package leetcode.P20200426;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import leetcode.TreeNode;

/**
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 * Created by yuchen.wu on 2020-04-26
 */

public class P145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node == null) {
                stack.pop();
                result.add(stack.pop().val);
                continue;
            }
            stack.push(null);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }

    public List<Integer> postorderTraversal3(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        LinkedList<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            result.addFirst(treeNode.val);
            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }
            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }
        }
        return result;
    }

    List<Integer> result = new ArrayList<>();
    public List<Integer> postorderTraversal2(TreeNode root) {
        if (root == null) {
            return result;
        }
        postorderTraversal2(root.left);
        postorderTraversal2(root.right);
        result.add(root.val);
        return result;
    }

}
