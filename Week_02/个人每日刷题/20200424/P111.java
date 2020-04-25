package leetcode.P20200424;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

import leetcode.TreeNode;

/**
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * Created by yuchen.wu on 2020-04-24
 */

public class P111 {

    /**
     * DFS
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null) {
            return 1 + minDepth(root.right);
        } else if (root.right == null) {
            return 1 + minDepth(root.left);
        } else {
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        }
    }

    class KeyValuePair{
        int deep;
        TreeNode treeNode;

        public KeyValuePair(int deep, TreeNode treeNode) {
            this.deep = deep;
            this.treeNode = treeNode;
        }
    }

    /**
     * DFS
     */
    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<KeyValuePair> stack = new Stack<>();
        stack.push(new KeyValuePair(1, root));
        int minDeep = Integer.MAX_VALUE;
        while (!stack.isEmpty()) {
            KeyValuePair pair = stack.pop();
            int nowDeep = pair.deep;
            TreeNode treeNode = pair.treeNode;
            if (treeNode.left == null && treeNode.right == null) {
                minDeep = Math.min(minDeep, nowDeep);
                continue;
            }
            if (treeNode.left != null) {
                stack.push(new KeyValuePair(1 + nowDeep, treeNode.left));
            }
            if (treeNode.right != null) {
                stack.push(new KeyValuePair(1 + nowDeep, treeNode.right));
            }
        }
        return minDeep;
    }

    /**
     * BFS
     */
    public int minDepth3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        int deep = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            deep++;
            while (size > 0) {
                TreeNode treeNode = queue.poll();
                if (treeNode.left == null && treeNode.right == null) {
                    return deep;
                }
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
                size--;
            }
        }
        return -1;
    }

}
