package leetcode.P20200424;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

import leetcode.Node;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/
 * Created by yuchen.wu on 2020-04-24
 */

public class P559 {

    /**
     * DFS
     * @param root
     * @return
     */
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int maxDeep = 0;
        for (Node node : root.children) {
            maxDeep = Math.max(maxDeep, maxDepth(node));
        }
        return maxDeep + 1;
    }

    class KeyValuePair{
        int deep;
        Node node;

        public KeyValuePair(int deep, Node node) {
            this.deep = deep;
            this.node = node;
        }
    }

    /**
     * DFS
     */
    public int maxDepth2(Node root) {
        if (root == null) {
            return 0;
        }
        Stack<KeyValuePair> stack = new Stack<>();
        stack.push(new KeyValuePair(1, root));
        int maxDeep = 0;
        while (!stack.isEmpty()) {
            KeyValuePair pair = stack.pop();
            int nowDeep = pair.deep;
            Node node = pair.node;
            if (node.children == null || node.children.size() == 0) {
                maxDeep = Math.max(maxDeep, nowDeep);
            } else {
                for (Node child : node.children) {
                    stack.push(new KeyValuePair(nowDeep + 1, child));
                }
            }
        }
        return maxDeep;
    }

    /**
     * BFS
     */
    public int maxDepth3(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        int maxDeep = 0;
        while (!queue.isEmpty()) {
            maxDeep++;
            int size = queue.size();
            while (size > 0) {
                Node node = queue.poll();
                if (node.children != null || node.children.size() > 0) {
                    for (Node child : node.children) {
                        queue.offer(child);
                    }
                }
                size--;
            }
        }
        return maxDeep;
    }
}
