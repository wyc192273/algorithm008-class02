package leetcode.P20200508;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import leetcode.TreeNode;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/#/description
 * Created by yuchen.wu on 2020-05-08
 */

public class P102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> line = new ArrayList<>();
            while (size > 0) {
                TreeNode treeNode = queue.poll();
                line.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
                size--;
            }
            result.add(line);
        }
        return result;
    }

}
