package leetcode.P20200531;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

import leetcode.TreeNode;

/**
 * https://leetcode-cn.com/problems/symmetric-tree/
 * Created by yuchen.wu on 2020-05-31
 */

public class P101 {

    class Node{

        TreeNode treeNode;

        public Node(TreeNode treeNode) {
            this.treeNode = treeNode;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return (left.val == right.val) && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(root.left));
        queue.add(new Node(root.right));
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayDeque<Node> arrayDeque = new ArrayDeque<>();
            while (size-- > 0) {
                Node treeNode = queue.remove();
                arrayDeque.add(treeNode);
                if (treeNode.treeNode == null) {
                    continue;
                }
                queue.add(new Node(treeNode.treeNode.left));
                queue.add(new Node(treeNode.treeNode.right));
            }
            if (arrayDeque.size() % 2 != 0) {
                return false;
            }
            while (arrayDeque.size() > 1) {
                Node left= arrayDeque.pollFirst();
                Node right = arrayDeque.pollLast();
                if (left.treeNode == null && right.treeNode != null) {
                    return false;
                }
                if (left.treeNode != null && right.treeNode == null) {
                    return false;
                }
                if (left.treeNode == null && right.treeNode == null) {
                    continue;
                }
                if (left.treeNode.val != right.treeNode.val) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new P101().isSymmetric(TreeNode.generate(new Integer[] { 1, 2, 2, null, 3, null, 3 }));
    }

}
