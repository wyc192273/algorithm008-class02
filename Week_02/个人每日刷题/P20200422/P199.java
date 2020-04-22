package leetcode.P20200422;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import leetcode.ListNode;
import leetcode.TreeNode;

/**
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/
 * Created by yuchen.wu on 2020-04-22
 */

public class P199 {

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean first = true;
            while (size > 0) {
                TreeNode treeNode = queue.poll();
                if (first) {
                    result.add(treeNode.val);
                    first = false;
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                size--;
            }
        }
        return result;
    }

}
