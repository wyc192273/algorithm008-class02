package leetcode.P20200424;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

import leetcode.TreeNode;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * Created by yuchen.wu on 2020-04-24
 */

public class P104 {

    /**
     * DFS
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    class KeyValuePair{
        int key;
        TreeNode treeNode;

        public KeyValuePair(int key, TreeNode treeNode) {
            this.key = key;
            this.treeNode = treeNode;
        }
    }

    /**
     * DFS stack
     */
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<KeyValuePair> stack = new Stack<>();
        stack.push(new KeyValuePair(1, root));
        int deep = 0;
        while (!stack.isEmpty()) {
            KeyValuePair pair = stack.pop();
            int nowDeep = pair.key;
            TreeNode treeNode = pair.treeNode;
            if (treeNode != null) {
                deep = Math.max(deep, nowDeep);
                if (treeNode.left != null) {
                    stack.push(new KeyValuePair(nowDeep + 1, treeNode.left));
                }
                if (treeNode.right != null) {
                    stack.push(new KeyValuePair(nowDeep + 1, treeNode.right));
                }
            }
        }
        return deep;
    }

    /**
     * BFS
     */
    public int maxDepth3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int deep = 0;
        while (!queue.isEmpty()) {
            deep++;
            int size = queue.size();
            while (size > 0) {
                TreeNode treeNode = queue.poll();
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
                size--;
            }
        }
        return deep;
    }
}
