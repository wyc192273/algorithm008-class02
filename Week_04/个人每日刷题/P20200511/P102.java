package leetcode.P20200511;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import leetcode.TreeNode;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/#/description
 * Created by yuchen.wu on 2020-05-11
 */

public class P102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> line = new ArrayList<>();
            int size = queue.size();
            while (size > 0) {
                TreeNode treeNode = queue.poll();
                line.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
                size--;
            }
            result.add(line);
        }
        return result;
    }

}
