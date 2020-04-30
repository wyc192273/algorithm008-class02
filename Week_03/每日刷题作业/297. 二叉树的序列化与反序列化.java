package leetcode.P20200430;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.TreeNode;


/**
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 * Created by yuchen.wu on 2020-04-30
 */

public class P297 {

    //DFS
    public static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "nil";
            }
            StringBuilder res = new StringBuilder();
            serialize(res, root);
            String result = res.toString();
            while (result.endsWith("nil,")) {
                result = result.substring(0, result.lastIndexOf("nil,"));
            }
            return result;
        }

        private void serialize(StringBuilder res, TreeNode root) {
            if (root == null) {
                res.append("nil,");
                return;
            }
            res.append(root.val).append(",");
            serialize(res, root.left);
            serialize(res, root.right);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.equals("nil")) {
                return null;
            }
            String[] s = data.split(",");
            LinkedList<Integer> list = new LinkedList<>();
            for (String c : s) {
                if (c.equals("nil")) {
                    list.offer(null);
                } else {
                    list.offer(Integer.parseInt(c));
                }
            }
            return deserialize(list);
        }

        private TreeNode deserialize(LinkedList<Integer> list) {
            Integer num = list.poll();
            if (num == null) {
                return null;
            }
            TreeNode treeNode = new TreeNode(num);
            treeNode.left = deserialize(list);
            treeNode.right = deserialize(list);
            return treeNode;
        }
    }

    //BFS
    public static class Codec2 {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "nil";
            }
            StringBuilder result = new StringBuilder();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                StringBuilder res = new StringBuilder();
                boolean allNull = true;
                while (size > 0) {
                    TreeNode treeNode = queue.poll();
                    if (treeNode == null) {
                        res.append("nil");
                    } else {
                        allNull = false;
                        res.append(treeNode.val);
                        queue.offer(treeNode.left);
                        queue.offer(treeNode.right);
                    }
                    res.append(",");
                    size--;
                }
                if (allNull) {
                    break;
                }
                result.append(res);
            }
            return result.substring(0, result.length() - 1);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.equals("nil")) {
                return null;
            }
            String[] s = data.split(",");
            Integer[] values = new Integer[s.length];
            int index = 0;
            for (String c : s) {
                if (c.equals("nil")) {
                    values[index++] = null;
                } else {
                    values[index++] = Integer.parseInt(c);
                }
            }
            Queue<TreeNode> queue = new ArrayDeque<>();
            TreeNode treeNode = new TreeNode(values[0]);
            queue.offer(treeNode);
            for (int i = 1; i < values.length; i += 2) {
                TreeNode node = queue.poll();
                if (values[i] != null) {
                    node.left = new TreeNode(values[i]);
                    queue.offer(node.left);
                }
                if (i + 1 < values.length && values[i + 1] != null) {
                    node.right = new TreeNode(values[i + 1]);
                    queue.offer(node.right);
                }
            }
            return treeNode;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Codec().serialize(TreeNode.generate(new Integer[] { 5, 2, 3, null, null, 2, 4, 3, 1 })));
    }

}
