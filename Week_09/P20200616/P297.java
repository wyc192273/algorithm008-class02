package leetcode2.P20200616;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import leetcode.TreeNode;

/**
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 * Created by yuchen.wu on 2020-06-16
 */

public class P297 {


    public class Codec2 {

        private static final String NULL = "null";

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder stringBuilder = new StringBuilder();
            if (root == null) {
                return NULL;
            }
            LinkedList<TreeNode> queue = new LinkedList<>();
            LinkedList<Integer> items = new LinkedList<>();
            queue.add(root);
            items.add(root.val);
            while (!queue.isEmpty() && !items.isEmpty()) {
                stringBuilder.append(",");
                TreeNode treeNode = queue.remove();
                if (treeNode == null) {
                    stringBuilder.append(NULL);
                } else {
                    items.remove();
                    stringBuilder.append(treeNode.val);
                    if (treeNode.left != null) {
                        items.add(treeNode.left.val);
                    }
                    queue.add(treeNode.left);
                    if (treeNode.right != null) {
                        items.add(treeNode.right.val);
                    }
                    queue.add(treeNode.right);
                }
            }
            return stringBuilder.substring(1);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.equals(NULL)) {
                return null;
            }
            Queue<TreeNode> queue = new ArrayDeque();
            String[] strs = data.split(",");
            TreeNode treeNode = new TreeNode(Integer.valueOf(strs[0]));
            queue.add(treeNode);
            for (int i = 1; i < strs.length; i+=2) {
                TreeNode root = queue.remove();
                if (strs[i].equals(NULL)) {
                    root.left = null;
                } else {
                    root.left = new TreeNode(Integer.valueOf(strs[i]));
                    queue.add(root.left);
                }
                if (i + 1 < strs.length) {
                    if (strs[i + 1].equals(NULL)) {
                        root.right = null;
                    } else {
                        root.right = new TreeNode(Integer.valueOf(strs[i + 1]));
                        queue.add(root.right);
                    }
                }
            }
            return treeNode;
        }
    }

}
